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

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categorias/novo")
    public String novaCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping("/categorias")
    public String cadastrarCategoria(@ModelAttribute Categoria categoria) {
        repository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", repository.findAll());
        return "categorias/lista";
    }

    @GetMapping("/categorias/excluir/{id}")
    public String excluirCategoria(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/categorias";
    }
}
