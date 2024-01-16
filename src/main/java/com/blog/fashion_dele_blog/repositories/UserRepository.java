package com.blog.fashion_dele_blog.repositories;

import com.blog.fashion_dele_blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByEmail(String email);

    User findUserByName(String name);
}
