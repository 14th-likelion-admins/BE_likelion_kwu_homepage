package com.example.be_likelion_kwu_homepage.project.global.exception;

import com.example.be_likelion_kwu_homepage.project.global.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e) {

        ResponseCode responseCode = e.getResponseCode();

        return ResponseEntity
                .status(responseCode.getStatus())
                .body(ApiResponse.fail(responseCode));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(MethodArgumentNotValidException e) {
        ResponseCode responseCode = ResponseCode.REQUIRED_FIELD_MISSING;

        return ResponseEntity
                .status(responseCode.getStatus())
                .body(ApiResponse.fail(responseCode));
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ApiResponse<Void>> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e) {
        ResponseCode responseCode = ResponseCode.FILE_SIZE_EXCEEDED;
        return ResponseEntity.status(responseCode.getStatus()).body(ApiResponse.fail(responseCode));
    }
}
