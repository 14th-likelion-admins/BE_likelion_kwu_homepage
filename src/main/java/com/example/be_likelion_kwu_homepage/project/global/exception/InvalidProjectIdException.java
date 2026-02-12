package com.example.be_likelion_kwu_homepage.project.global.exception;

public class InvalidProjectIdException extends BusinessException {

    public InvalidProjectIdException() {
        super(ResponseCode.INVALID_PROJECT_ID);
    }
}
