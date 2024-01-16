package com.blog.fashion_dele_blog.dto;

import com.blog.fashion_dele_blog.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
   // private Long id;
    private String name;
    private String email;
    private Role role;
}
