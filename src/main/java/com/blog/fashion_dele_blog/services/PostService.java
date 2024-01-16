package com.blog.fashion_dele_blog.services;

import com.blog.fashion_dele_blog.dto.PostDto;
import com.blog.fashion_dele_blog.dto.PostRequestDto;
import com.blog.fashion_dele_blog.entities.Post;

import java.util.Optional;

public interface PostService {
    PostDto createPost(PostRequestDto Request);

    Optional<Post> getPostById(Long id);

    //List<Post> findAll();

    //PostDto
    PostDto searchPost(String title);
}
