package com.example.demo.dtos;

public record ApiResponse<T>(
        String message,
        boolean success,
        T data
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("Request successful", true, data);
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(message, true, data);
    }
}
