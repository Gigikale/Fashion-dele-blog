package com.blog.fashion_dele_blog.entities;

import com.blog.fashion_dele_blog.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post extends BaseModel{
    private String title;

    private String description;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Like> likes;

}
