package com.codegym.springbootlearning.payload.response;

import com.codegym.springbootlearning.entity.Book;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Data
@Builder
public class ResponseDto {
    private String message;
    private HttpStatus status;
    private Book data;
}
