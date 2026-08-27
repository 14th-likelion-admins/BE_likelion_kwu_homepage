package com.example.be_likelion_kwu_homepage.project.dto.response;
import com.example.be_likelion_kwu_homepage.project.entity.Project;
public record ProjectSummaryResponse(Long id, String title, String tag, String description, String generation) {
    public static ProjectSummaryResponse from(Project project) {
        return new ProjectSummaryResponse(project.getId(), project.getTitle(), project.getCategory() == null ? null : project.getCategory().name(),
                project.getDescription() == null ? project.getSubTitle() : project.getDescription(), project.getGeneration());
    }
}
