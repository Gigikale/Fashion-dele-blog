package com.blog.fashion_dele_blog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MyException extends RuntimeException{
    private String message;

    private HttpStatus status;

    private final LocalDateTime time = LocalDateTime.now();
}
