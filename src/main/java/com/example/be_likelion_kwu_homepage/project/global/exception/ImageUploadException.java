package com.example.be_likelion_kwu_homepage.project.global.exception;

public class ImageUploadException extends BusinessException {
    public ImageUploadException() { super(ResponseCode.IMAGE_UPLOAD_FAILED); }
}
