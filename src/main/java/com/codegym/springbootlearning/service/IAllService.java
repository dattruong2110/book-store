package com.codegym.springbootlearning.service;

import com.codegym.springbootlearning.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IAllService<E> {
    Page<E> findAll(String name, Pageable pageable);
    E findById(UUID id);
    void save(E e);
    void deletedById(UUID id);
    void update(E e);
}
