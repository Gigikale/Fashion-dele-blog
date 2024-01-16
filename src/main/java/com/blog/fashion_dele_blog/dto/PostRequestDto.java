package com.blog.fashion_dele_blog.dto;

import com.blog.fashion_dele_blog.enums.Category;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PostRequestDto {
    private Long userId;
    private String title;
    @NotNull(message = "Post description cannot be empty")
    private  String description;
    private String imageUrl;
    private Category category;
}
