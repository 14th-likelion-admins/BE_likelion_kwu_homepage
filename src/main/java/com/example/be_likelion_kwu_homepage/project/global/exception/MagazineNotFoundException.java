package com.example.be_likelion_kwu_homepage.project.global.exception;

public class MagazineNotFoundException extends BusinessException {
    public MagazineNotFoundException() { super(ResponseCode.MAGAZINE_NOT_FOUND); }
}
