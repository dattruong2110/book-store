package com.codegym.springbootlearning.payload.request;

import com.codegym.springbootlearning.entity.Book;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class EditBookRequest {
    private UUID id;
    private String name;
    private UUID authorID;
    private String  description;
    private String image;
    private Double price;
    private Integer quantity;
    private String category;
    private String publisher;
    private String year;
    private String language;
}
