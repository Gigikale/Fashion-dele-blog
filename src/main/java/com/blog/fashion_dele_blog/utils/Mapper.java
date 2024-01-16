package com.blog.fashion_dele_blog.utils;

import com.blog.fashion_dele_blog.dto.CommentDto;
import com.blog.fashion_dele_blog.dto.PostDto;
import com.blog.fashion_dele_blog.dto.UserDto;
import com.blog.fashion_dele_blog.entities.Comment;
import com.blog.fashion_dele_blog.entities.Post;
import com.blog.fashion_dele_blog.entities.User;

public class Mapper {
    public static UserDto userToUserDto(User user){
        return UserDto.builder()
              //  .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

    public static PostDto postToPostDto(Post post){
        return PostDto.builder()
                //.id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .category(post.getCategory())
                .imageUrl(post.getImageUrl())
                // .createdAt(post.getCreatedAt())
                .build();
    }

    public static CommentDto commentToDto(Comment comment) {
        return CommentDto.builder()
                //.id(comment.getId())
                .comment(comment.getComment())
                .build();
    }
}
