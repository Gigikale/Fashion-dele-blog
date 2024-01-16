package com.blog.fashion_dele_blog.services;

import com.blog.fashion_dele_blog.dto.CommentDto;
import com.blog.fashion_dele_blog.dto.CommentRequestDto;

public interface CommentService {
    CommentDto addComment(CommentRequestDto comment);
}
