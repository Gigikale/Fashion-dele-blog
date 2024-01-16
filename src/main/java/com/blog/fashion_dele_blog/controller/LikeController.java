package com.blog.fashion_dele_blog.controller;

import com.blog.fashion_dele_blog.entities.Post;
import com.blog.fashion_dele_blog.entities.User;
import com.blog.fashion_dele_blog.services.LikeService;
import com.blog.fashion_dele_blog.services.PostService;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/posts")
public class LikeController {
    private LikeService likeService;

    private PostService postService;

    @PostMapping("like/{postId}/{userId}")
    ResponseEntity<String> likePost(@PathVariable Long postId, @PathVariable Long userId) {
        likeService.addLike(postId, userId);

        Post post = postService.getPostById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found"));
        String message =  "Post has been liked";
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("unlike/{likeId}")
    ResponseEntity<String>unlikePost(@PathVariable Long likeId){
        likeService.deleteLike(likeId);
        String message =  "Post has been unliked";
        return ResponseEntity.ok(message);

    }
}
