package com.blog.fashion_dele_blog.services.serviceImplementation;

import com.blog.fashion_dele_blog.dto.CommentDto;
import com.blog.fashion_dele_blog.dto.CommentRequestDto;
import com.blog.fashion_dele_blog.entities.Comment;
import com.blog.fashion_dele_blog.entities.Post;
import com.blog.fashion_dele_blog.entities.User;
import com.blog.fashion_dele_blog.enums.Role;
import com.blog.fashion_dele_blog.exceptions.NoAuthorizationException;
import com.blog.fashion_dele_blog.exceptions.PostNotFoundException;
import com.blog.fashion_dele_blog.exceptions.UserNotFoundException;
import com.blog.fashion_dele_blog.repositories.CommentRepository;
import com.blog.fashion_dele_blog.repositories.UserRepository;
import com.blog.fashion_dele_blog.services.CommentService;
import com.blog.fashion_dele_blog.services.PostService;
import com.blog.fashion_dele_blog.utils.Mapper;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private PostService postService;
    @Override
    public CommentDto addComment(CommentRequestDto comment) {
        User user = userRepository.findById(comment.getUserId())
                .orElseThrow(() -> new UserNotFoundException("This user does not exist"));



        if (!(Role.ADMIN.equals(user.getRole()) || Role.CUSTOMER.equals(user.getRole())))
        {
            throw new NoAuthorizationException("You are not allowed to comment.");
        }


        Post post = postService.getPostById(comment.getPostId())
                .orElseThrow(() -> new PostNotFoundException("The specified post does not exist"));


        return Mapper.commentToDto(commentRepository.save(
                Comment.builder()
                        .comment(comment.getComment())
                        .post(post)
                        .user(user)
                        .build()
        ));
    }

}
