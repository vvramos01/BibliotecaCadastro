package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.model.Categoria;
import br.com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {

    private final CategoriaRepository repository;

    // Injeção de dependência por construtor
    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    // Exibe o formulário de cadastro
    @GetMapping("/categorias/novo")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    // ENDPOINT DE CADASTRO
    @PostMapping("/categorias")
    public String cadastrarCategoria(@ModelAttribute Categoria categoria) {
        repository.save(categoria);
        return "redirect:/categorias";
    }

    // ENDPOINT DE LISTAGEM
    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", repository.findAll());
        return "categorias/lista";
    }

    // ENDPOINT DE EXCLUSÃO (POST: uma ação que altera dados não deve ser feita por GET)
    @PostMapping("/categorias/{id}/excluir")
    public String excluirCategoria(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/categorias";
    }
}
