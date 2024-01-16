package com.blog.fashion_dele_blog.controller;

import com.blog.fashion_dele_blog.dto.CommentDto;
import com.blog.fashion_dele_blog.dto.CommentRequestDto;
import com.blog.fashion_dele_blog.services.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/make-comment")
    public ResponseEntity<CommentDto> create(@Valid @RequestBody CommentRequestDto Request){
        return new ResponseEntity<>(commentService.addComment(Request), HttpStatus.CREATED);
    }
}
