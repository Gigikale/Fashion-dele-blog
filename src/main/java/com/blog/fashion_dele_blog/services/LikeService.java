package com.blog.fashion_dele_blog.services;

public interface LikeService {
    void addLike(Long userId, Long postId);

    void deleteLike(Long likeId);
}
