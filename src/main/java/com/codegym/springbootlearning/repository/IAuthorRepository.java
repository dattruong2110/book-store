package com.codegym.springbootlearning.repository;

import com.codegym.springbootlearning.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IAuthorRepository extends JpaRepository<Author, UUID> {
    Page<Author> findByNameContainsAndIsDeletedIsFalse(String name, Pageable pageable);
}
