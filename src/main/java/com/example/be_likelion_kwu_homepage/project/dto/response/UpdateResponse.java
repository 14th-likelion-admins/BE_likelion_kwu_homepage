package com.example.be_likelion_kwu_homepage.project.dto.response;

import com.example.be_likelion_kwu_homepage.project.entity.Project;

public record UpdateResponse(
        Long projectId,
        String title,
        String subTitle,
        String content,
        String imageUrl,
        String category,
        Integer generation
) {
    public static UpdateResponse from(Project project) {
        return new UpdateResponse(
                project.getId(),
                project.getTitle(),
                project.getSubTitle(),
                project.getContent(),
                project.getImageUrl(),
                project.getCategory().name(),
                project.getGeneration()
        );
    }
}
