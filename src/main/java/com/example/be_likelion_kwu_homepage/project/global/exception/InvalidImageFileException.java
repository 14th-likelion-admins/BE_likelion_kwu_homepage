package com.example.be_likelion_kwu_homepage.project.global.exception;

public class InvalidImageFileException extends BusinessException {
    public InvalidImageFileException() { super(ResponseCode.INVALID_IMAGE_FILE); }
}
