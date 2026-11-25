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

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/autores/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/autores")
    public String cadastrarAutor(@ModelAttribute Autor autor) {
        repository.save(autor);
        return "redirect:/autores";
    }

    @GetMapping("/autores")
    public String listarAutores(Model model) {
        model.addAttribute("autores", repository.findAll());
        return "autores/lista";
    }

    @GetMapping("/autores/excluir/{id}")
    public String excluirAutor(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/autores";
    }
}
