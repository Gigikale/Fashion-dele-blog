package com.blog.fashion_dele_blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends BaseModel{
    private String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
