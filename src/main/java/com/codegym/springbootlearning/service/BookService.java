package com.codegym.springbootlearning.service;

import com.codegym.springbootlearning.entity.Book;
import com.codegym.springbootlearning.repository.IBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    @Override
    public Page<Book> findAll(String name, Pageable pageable) {
        return bookRepository.findByNameContainsAndIsDeletedIsFalse(name, pageable);
    }

    @Override
    public Book findById(UUID id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deletedById(UUID id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }
}
