package com.example.be_likelion_kwu_homepage.project.dto.response;

import com.example.be_likelion_kwu_homepage.project.entity.Project;

public record DetailResponse(
        Long projectId,
        String title,
        String subTitle,
        String content,
        String imageUrl
) {
    public DetailResponse(Project project) {
        this(project.getId(), project.getTitle(), project.getSubTitle(), project.getContent(), project.getImageUrl());
    }
}
