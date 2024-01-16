package com.blog.fashion_dele_blog.repositories;

import com.blog.fashion_dele_blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitleIgnoreCase(String title);
}
