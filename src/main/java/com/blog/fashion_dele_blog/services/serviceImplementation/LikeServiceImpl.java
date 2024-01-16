package com.blog.fashion_dele_blog.services.serviceImplementation;

import com.blog.fashion_dele_blog.entities.Like;
import com.blog.fashion_dele_blog.repositories.LikeRepository;
import com.blog.fashion_dele_blog.repositories.PostRepository;
import com.blog.fashion_dele_blog.repositories.UserRepository;
import com.blog.fashion_dele_blog.services.LikeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;


    @Override
    public void addLike(Long postId, Long  userId) {
        likeRepository.save(Like.builder()
                .post(postRepository.findById(postId).orElseThrow(
                        () -> new EntityNotFoundException(" this post is not available or has been deleted")
                ))
                .user(userRepository.findById(userId).orElseThrow(
                        ()-> new EntityNotFoundException("user unavailable")
                ))

                .build()
        );


    }

    @Override
    public void deleteLike(Long likeId) {likeRepository.deleteById(likeId); }


}
