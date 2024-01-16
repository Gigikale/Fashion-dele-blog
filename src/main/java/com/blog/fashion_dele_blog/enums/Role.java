package com.blog.fashion_dele_blog.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.STRING)
@Getter
public enum Role {
    ADMIN, CUSTOMER, VISITOR;
}
