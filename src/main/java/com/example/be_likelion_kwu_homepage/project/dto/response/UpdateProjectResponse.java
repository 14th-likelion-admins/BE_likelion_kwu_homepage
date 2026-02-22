package com.example.be_likelion_kwu_homepage.project.dto.response;

import com.example.be_likelion_kwu_homepage.project.domain.ProjectCategory;
import com.example.be_likelion_kwu_homepage.project.entity.Project;

public record UpdateProjectResponse(
        Long projectId,
        String title,
        String subTitle,
        String content,
        String imageUrl,
        ProjectCategory category,
        Integer generation
) {
    public static UpdateProjectResponse from(Project project) {
        return new UpdateProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getSubTitle(),
                project.getContent(),
                project.getImageUrl(),
                project.getCategory(),
                project.getGeneration()
        );
    }
}
