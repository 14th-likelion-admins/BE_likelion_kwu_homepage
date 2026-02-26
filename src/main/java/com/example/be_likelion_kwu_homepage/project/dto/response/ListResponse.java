package com.example.be_likelion_kwu_homepage.project.dto.response;

import com.example.be_likelion_kwu_homepage.project.entity.Project;

public record ListResponse(
        Long projectId,
        String title,
        String subTitle,
        String imageUrl
) {
    public static ListResponse from(Project project) {
        return new ListResponse(
                project.getId(),
                project.getTitle(),
                project.getSubTitle(),
                project.getImageUrl()
        );
    }
}
