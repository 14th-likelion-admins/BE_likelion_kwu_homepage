package com.example.be_likelion_kwu_homepage.project.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    OK(HttpStatus.OK, "200OK", "Request completed successfully."),
    CREATED(HttpStatus.CREATED, "201CREATED", "Resource created successfully."),
    INVALID_PROJECT_ID(HttpStatus.BAD_REQUEST, "400REPORT", "Invalid project ID."),
    REQUIRED_FIELD_MISSING(HttpStatus.BAD_REQUEST, "400REPORT", "A required field is missing or invalid."),
    INVALID_IMAGE_FILE(HttpStatus.BAD_REQUEST, "400IMAGE", "Invalid image file."),
    FILE_SIZE_EXCEEDED(HttpStatus.BAD_REQUEST, "400IMAGE_SIZE", "Image files must not exceed 10MB."),
    S3_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "500S3", "Image upload failed."),
    JSON_PROCESSING_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "500JSON", "Project data could not be processed.");
    private final HttpStatus status; private final String code; private final String message;
    ResponseCode(HttpStatus status, String code, String message) { this.status = status; this.code = code; this.message = message; }
}
