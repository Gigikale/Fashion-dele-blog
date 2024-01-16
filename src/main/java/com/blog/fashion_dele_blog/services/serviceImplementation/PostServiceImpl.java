package com.blog.fashion_dele_blog.services.serviceImplementation;

import com.blog.fashion_dele_blog.dto.PostDto;
import com.blog.fashion_dele_blog.dto.PostRequestDto;
import com.blog.fashion_dele_blog.entities.Post;
import com.blog.fashion_dele_blog.entities.User;
import com.blog.fashion_dele_blog.enums.Role;
import com.blog.fashion_dele_blog.exceptions.NoAuthorizationException;
import com.blog.fashion_dele_blog.exceptions.PostNotFoundException;
import com.blog.fashion_dele_blog.exceptions.UserNotFoundException;
import com.blog.fashion_dele_blog.repositories.PostRepository;
import com.blog.fashion_dele_blog.repositories.UserRepository;
import com.blog.fashion_dele_blog.services.PostService;
import com.blog.fashion_dele_blog.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private UserRepository userRepository;
    private final Mapper mapper = new Mapper();
    @Override
    public PostDto createPost(PostRequestDto Request) {
        User admin = userRepository.findById(Request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with ID " + Request.getUserId() + " not found"));

        if (admin.getRole() == Role.ADMIN) {
            Post newPost = Post.builder()
                    .title(Request.getTitle())
                    .description(Request.getDescription())
                    .category(Request.getCategory())
                    .imageUrl(Request.getImageUrl())
                    .user(admin)
                    .build();

            postRepository.save(newPost);
            return Mapper.postToPostDto(newPost);
    }
        throw new NoAuthorizationException("Only an admin can create a post");
    }

    @Override
    public Optional<Post> getPostById(Long id) {return postRepository.findById(id); }



    @Override
    public PostDto searchPost(String title) {
        Post post = postRepository.findByTitleIgnoreCase(title).orElseThrow(() -> new PostNotFoundException("Post not available"));
        if(post != null) {
            Post searchedPost = Post.builder()
                    .title(post.getTitle())
                    .description(post.getDescription())
                    .category(post.getCategory())
                    .build();

            return Mapper.postToPostDto(searchedPost);
        }
        throw new PostNotFoundException("Post details not complete");
    }
}
