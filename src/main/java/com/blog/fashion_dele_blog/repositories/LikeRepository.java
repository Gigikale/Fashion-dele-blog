package com.blog.fashion_dele_blog.repositories;

import com.blog.fashion_dele_blog.entities.Like;
import com.blog.fashion_dele_blog.entities.Post;
import com.blog.fashion_dele_blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> getPostLikeByPost(Post post);

    Like getPostLikeByPostAndUser(Post post, User user);
}
