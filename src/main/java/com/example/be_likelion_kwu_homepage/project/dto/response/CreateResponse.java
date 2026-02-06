package com.example.be_likelion_kwu_homepage.project.dto.response;

public record CreateResponse(
        Long projectid,
        String title,
        String subTitle,
        String content,
        String imageUrl,
        String category,
        Integer generation
) {}
