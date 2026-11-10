package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.model.Autor;
import br.com.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {

    // Aula 6 (CRUD em memória) usava:  private List<Autor> autores = new ArrayList<>();
    // Aula 7 (persistência): a responsabilidade de guardar dados passa ao Repository.
    private final AutorRepository repository;

    // Injeção de dependência por construtor
    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    // CREATE (1/2) - exibe o formulário
    @GetMapping("/autores/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    // CREATE (2/2) - Aula 6: autores.add(autor)  ->  Aula 7: repository.save(autor)
    @PostMapping("/autores")
    public String cadastrarAutor(@ModelAttribute Autor autor) {
        repository.save(autor);
        // Redirect evita o reenvio do formulário ao atualizar a página (F5)
        return "redirect:/autores";
    }

    // READ - Aula 6: lista em memória  ->  Aula 7: repository.findAll()
    @GetMapping("/autores")
    public String listarAutores(Model model) {
        model.addAttribute("autores", repository.findAll());
        return "autores/lista";
    }

    // DELETE - Aula 6 removia pelo índice da lista (autores.remove(indice)).
    // Com banco de dados usamos o ID único e imutável (a posição na lista mudava a cada exclusão).
    @GetMapping("/autores/excluir/{id}")
    public String excluirAutor(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/autores";
    }
}
