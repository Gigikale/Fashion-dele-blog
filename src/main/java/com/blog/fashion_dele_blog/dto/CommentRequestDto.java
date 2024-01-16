package com.blog.fashion_dele_blog.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentRequestDto {
    @NotNull(message="comment cannot be null")
    private String comment;
    @NotNull(message="ID of commenter required")
    private Long userId;
    private Long postId;
}
