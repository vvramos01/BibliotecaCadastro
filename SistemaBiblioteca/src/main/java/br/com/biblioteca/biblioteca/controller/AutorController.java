package br.com.biblioteca.biblioteca.controller;

import br.com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AutorController {

    @GetMapping("/autores/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/autores")
    public String cadastrarAutor(@ModelAttribute Autor autor, Model model) {
        model.addAttribute("autor", autor);
        return "autores/confirmacao";
    }
}