package com.blog.fashion_dele_blog.services;

import com.blog.fashion_dele_blog.dto.UserDto;
import com.blog.fashion_dele_blog.dto.UserRequestDto;

public interface UserService {

    UserDto addAdminUser(UserRequestDto request);
    UserDto addUser(UserRequestDto request);

    // UserDto login(UserRequestDto request);

    UserDto getUserById(Long id);

    UserDto getUserByName(String name);
}
