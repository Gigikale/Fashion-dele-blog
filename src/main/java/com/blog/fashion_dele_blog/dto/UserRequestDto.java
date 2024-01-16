package com.blog.fashion_dele_blog.dto;

import com.blog.fashion_dele_blog.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
public class UserRequestDto {
    @NotBlank(message="fill in name")
    private String name;
    @Email
    private String email;
    @Length(message = "password length must be greater than 8, less than 20", min = 8, max = 20)
    private String password;
    private Role role;
}
