package com.example.be_likelion_kwu_homepage.project.dto.response;

import com.example.be_likelion_kwu_homepage.project.entity.Project;

public record ListResponse(
        String title,
        String subTitle,
        String imageUrl,
        Long projectId
) {
    public static ListResponse from(Project project) {
        return new ListResponse(
                project.getTitle(),
                project.getSubTitle(),
                project.getImageUrl(),
                project.getId()
        );
    }
}
