package com.example.be_likelion_kwu_homepage.project.global.dto;

import com.example.be_likelion_kwu_homepage.project.global.exception.ResponseCode;

public record ApiResponse<T>(
        boolean success,
        String code,
        String message,
        T data
) {

    // 성공
    public static <T> ApiResponse<T> success(ResponseCode responseCode, T data) {
        return new ApiResponse<>(
                true,
                responseCode.getCode(),
                responseCode.getMessage(),
                data
        );
    }

    // 실패
    public static ApiResponse<Void> fail(ResponseCode responseCode) {
        return new ApiResponse<>(
                false,
                responseCode.getCode(),
                responseCode.getMessage(),
                null
        );
    }
}