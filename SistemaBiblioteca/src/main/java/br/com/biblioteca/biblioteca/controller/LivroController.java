package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.model.Livro;
import br.com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/livros/novo")
    public String novoLivro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/formulario";
    }

    // serve para cadastrar e para atualizar: se o livro vier com id, o save() atualiza
    @PostMapping("/livros")
    public String salvarLivro(@ModelAttribute Livro livro) {
        repository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/livros")
    public String listarLivros(Model model) {
        model.addAttribute("livros", repository.findAll());
        return "livros/lista";
    }

    @GetMapping("/livros/editar/{id}")
    public String editarLivro(@PathVariable Long id, Model model) {
        Livro livro = repository.findById(id).orElseThrow();
        model.addAttribute("livro", livro);
        return "livros/formulario";
    }

    @GetMapping("/livros/excluir/{id}")
    public String excluirLivro(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/livros";
    }
}
