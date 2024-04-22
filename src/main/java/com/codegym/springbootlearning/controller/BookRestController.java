package com.codegym.springbootlearning.controller;

import com.codegym.springbootlearning.entity.Book;
import com.codegym.springbootlearning.service.IAuthorService;
import com.codegym.springbootlearning.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookRestController {
    private final IBookService bookService;
    private final IAuthorService authorService;

    @RequestMapping("/list")
    public ResponseEntity<Page<Book>> findAll(@RequestParam(defaultValue = "") String name,
                                              @PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(bookService.findAll(name, pageable), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(Book book) {
        bookService.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletedById(@PathVariable UUID id) {
        bookService.deletedById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
