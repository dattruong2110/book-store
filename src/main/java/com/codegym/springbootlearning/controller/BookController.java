package com.codegym.springbootlearning.controller;

import com.codegym.springbootlearning.entity.Book;
import com.codegym.springbootlearning.service.IAuthorService;
import com.codegym.springbootlearning.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final IBookService bookService;
    private final IAuthorService authorService;

    @GetMapping
    public ModelAndView showList(@RequestParam(defaultValue = "") String name,
                                 @PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("Book/ListBook");
        modelAndView.addObject("books", bookService.findAll(name, pageable));
        modelAndView.addObject("authors", authorService.findAll(name, pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("Book/CreateBook");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("authors", authorService.findAll("", pageable));
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBook(Book book) {
        bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public ModelAndView showBook(@PathVariable UUID id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("Book/InfoBook");
        modelAndView.addObject("book", bookService.findById(id));
        modelAndView.addObject("authors", authorService.findAll("", pageable));
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("name") String name, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("Book/ListBook");
        modelAndView.addObject("books", bookService.findAll(name, pageable));
        modelAndView.addObject("authors", authorService.findAll("", pageable));
        return modelAndView;
    }

    @PutMapping("/update/{id}")
    public String edit(Book book) {
        bookService.update(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable UUID id) {
        bookService.deletedById(id);
        return "redirect:/books";
    }
}
