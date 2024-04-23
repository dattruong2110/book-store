package com.codegym.springbootlearning.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/*
Entity là 1 class trong Java, tương ứng ovi71 1 table trong DB
Entity bắt buộc phải là POJO (Plain Old Java Object)
POJO -> 1 đối tượng chỉ biểu diễn dữ liệu, không thao tác với dữ liệu
Entity phải có 1 primary key (khóa chi phân)
Entity phải có 1 constructor không tham số
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;
    private Double price;
    private Integer quantity;
    private String category;
    private String publisher;
    private String year;
    private String language;
    @Column(columnDefinition = "boolean default false")
    private Boolean isDeleted = Boolean.FALSE;
}
