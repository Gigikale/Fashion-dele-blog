package com.blog.fashion_dele_blog.services.serviceImplementation;

import com.blog.fashion_dele_blog.dto.UserDto;
import com.blog.fashion_dele_blog.dto.UserRequestDto;
import com.blog.fashion_dele_blog.entities.User;
import com.blog.fashion_dele_blog.enums.Role;
import com.blog.fashion_dele_blog.exceptions.MyException;
import com.blog.fashion_dele_blog.exceptions.UserNotFoundException;
import com.blog.fashion_dele_blog.repositories.UserRepository;
import com.blog.fashion_dele_blog.services.UserService;
import com.blog.fashion_dele_blog.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto addAdminUser(UserRequestDto request) {
        User existingUser = userRepository.findUsersByEmail(request.getEmail());

        if (existingUser != null) {
            throw new MyException("User with this email already exists", HttpStatus.CONFLICT);
        }

        User adminUser = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.ADMIN)  // Set the role to ADMIN for admin users
                .build();


        return Mapper.userToUserDto(userRepository.save(adminUser));
    }
    @Override
    public UserDto addUser(UserRequestDto request) {
        User existingUser = userRepository.findUsersByEmail(request.getEmail());
        if (existingUser != null) {
            throw new MyException("User with this email already exists", HttpStatus.CONFLICT);
        }

        return Mapper.userToUserDto(userRepository.save(
                User.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .password(request.getPassword())
                        .role(request.getRole())
                        .build()
        ));

    }

    @Override
    public UserDto getUserById(Long id) {
        return Mapper.userToUserDto(userRepository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("User Not Found")
        ));
    }

    @Override
    public UserDto getUserByName(String name) {
        User user = userRepository.findUserByName(name);
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        return Mapper.userToUserDto(user);
    }
}
