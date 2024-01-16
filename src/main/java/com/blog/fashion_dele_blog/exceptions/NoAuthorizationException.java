package com.blog.fashion_dele_blog.exceptions;

public class NoAuthorizationException extends RuntimeException {
    private String message;
    public NoAuthorizationException(String message) {
        super(message);
        this.message=message;
    }
}
