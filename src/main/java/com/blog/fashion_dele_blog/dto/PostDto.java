package com.blog.fashion_dele_blog.dto;

import com.blog.fashion_dele_blog.enums.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private String title;
    private  String description;
    private String imageUrl;
    private Category category;
}
