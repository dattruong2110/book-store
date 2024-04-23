package com.codegym.springbootlearning.converter;

import com.codegym.springbootlearning.payload.request.EditBookRequest;
import com.codegym.springbootlearning.entity.Author;
import com.codegym.springbootlearning.entity.Book;
import com.codegym.springbootlearning.service.IAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DtoToEntity {
    private final IAuthorService authorService;
    public Book convert(Book book, EditBookRequest bookRequest) {
        Author author = authorService.findById(bookRequest.getAuthorID());
        if (author.equals(book.getAuthor())) {
            BeanUtils.copyProperties(bookRequest, book);
        }
        return book;
    }
}
