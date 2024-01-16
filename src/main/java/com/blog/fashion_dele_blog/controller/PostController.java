package com.blog.fashion_dele_blog.controller;

import com.blog.fashion_dele_blog.dto.PostDto;
import com.blog.fashion_dele_blog.dto.PostRequestDto;
import com.blog.fashion_dele_blog.services.LikeService;
import com.blog.fashion_dele_blog.services.PostService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/posts")
public class PostController {
    private PostService postService;

    private LikeService likeService;

    @PostMapping("/make-post")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostRequestDto Request){
        return new ResponseEntity<>(postService.createPost(Request), HttpStatus.CREATED);
    }
    @GetMapping("/searchPost")
    public ResponseEntity<PostDto> searchPost(@Param("title") String title) {
        return new ResponseEntity<>(postService.searchPost(title), HttpStatus.OK);
    }

}
