package com.blog.fashion_dele_blog.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse<T> {
    private String message;
    private boolean success;
    private Object data;
    private HttpStatus status;


    public ApiResponse(String message, boolean success, Object data, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.data = data;
        this.status = status;
    }

    public ApiResponse(String message, boolean success, HttpStatus status) {
        this.message = message;
        this.success = success;
        this.status = status;
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;

    }
}
