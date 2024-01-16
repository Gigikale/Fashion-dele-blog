package com.blog.fashion_dele_blog.services.serviceImplementation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.blog.fashion_dele_blog.dto.UserRequestDto;
import com.blog.fashion_dele_blog.entities.User;
import com.blog.fashion_dele_blog.enums.Role;
import com.blog.fashion_dele_blog.exceptions.MyException;
import com.blog.fashion_dele_blog.repositories.UserRepository;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;


    @Test
    void testAddUser() {
        User user = new User();
        user.setComments(new ArrayList<>());
        user.setCreatedAt(mock(Timestamp.class));
        user.setEmail("Kale@yahoo.com");
        user.setId(1L);
        user.setName("Kale");
        user.setPassword("111111111");
        user.setPosts(new ArrayList<>());
        user.setRole(Role.ADMIN);
        user.setUpdatedAt(mock(Timestamp.class));
        when(userRepository.findUsersByEmail(Mockito.<String>any())).thenReturn(user);
        UserRequestDto request = mock(UserRequestDto.class);
        when(request.getEmail()).thenReturn("Kale@yahoo.com");
        assertThrows(MyException.class, () -> userServiceImpl.addUser(request));
        verify(request).getEmail();
        verify(userRepository).findUsersByEmail(Mockito.<String>any());
    }


    @Test
    void testAddUser2() {
        UserRequestDto request = mock(UserRequestDto.class);
        when(request.getEmail()).thenThrow(new MyException());
        assertThrows(MyException.class, () -> userServiceImpl.addUser(request));
        verify(request).getEmail();
    }
}
