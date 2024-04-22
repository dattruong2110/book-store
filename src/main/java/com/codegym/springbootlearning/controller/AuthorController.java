package com.codegym.springbootlearning.controller;

import com.codegym.springbootlearning.entity.Author;
import com.codegym.springbootlearning.service.IAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorController {
    private final IAuthorService authorService;

    @GetMapping
    public ModelAndView showList(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("Author/ListAuthor");
        modelAndView.addObject("authors", authorService.findAll("", pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("Author/CreateAuthor", "author", new Author());
    }

    @PostMapping("/create")
    public String createAuthor(Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}")
    public ModelAndView showAuthor(@PathVariable UUID id) {
        ModelAndView modelAndView = new ModelAndView("Author/InfoAuthor");
        modelAndView.addObject("author", authorService.findById(id));
        return modelAndView;
    }
}
