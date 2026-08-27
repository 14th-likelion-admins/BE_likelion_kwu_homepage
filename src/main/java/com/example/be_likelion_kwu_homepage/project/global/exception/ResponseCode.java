package com.example.be_likelion_kwu_homepage.project.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {
    // 성공
    OK(HttpStatus.OK, "200OK", "요청이 성공적으로 처리되었습니다."),
    CREATED(HttpStatus.CREATED, "201CREATED", "리소스 생성이 완료되었습니다."),

    // 실패
    INVALID_PROJECT_ID(HttpStatus.BAD_REQUEST, "400REPORT", "유효하지 않은 프로젝트 ID입니다."),
    MAGAZINE_NOT_FOUND(HttpStatus.NOT_FOUND, "404MAGAZINE", "매거진을 찾을 수 없습니다."),
    INVALID_IMAGE_FILE(HttpStatus.BAD_REQUEST, "400IMAGE", "이미지 파일만 10MB 이하로 업로드할 수 있습니다."),
    IMAGE_UPLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "500IMAGE", "이미지 업로드에 실패했습니다."),
    REQUIRED_FIELD_MISSING(HttpStatus.BAD_REQUEST, "400REPORT", "필수 입력값이 누락되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

    ResponseCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
