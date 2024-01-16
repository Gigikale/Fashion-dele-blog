package com.blog.fashion_dele_blog.controller;

import com.blog.fashion_dele_blog.dto.UserDto;
import com.blog.fashion_dele_blog.dto.UserRequestDto;
import com.blog.fashion_dele_blog.exceptions.MyException;
import com.blog.fashion_dele_blog.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final UserService userService;
    @PostMapping("/addAdmin")
    public ResponseEntity<UserDto> addAdminUser(@Valid @RequestBody UserRequestDto request) {
        try {
            UserDto newAdmin = userService.addAdminUser(request);
            return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
        } catch (MyException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("addUser")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserRequestDto request) {
        return new ResponseEntity<>(userService.addUser(request), HttpStatus.CREATED);
    }

    @GetMapping("/userByName/{name}")
    public ResponseEntity<UserDto> getUserByName(@Param("name") String name) {
        return new ResponseEntity<>(userService.getUserByName(name), HttpStatus.ACCEPTED);
    }

}
