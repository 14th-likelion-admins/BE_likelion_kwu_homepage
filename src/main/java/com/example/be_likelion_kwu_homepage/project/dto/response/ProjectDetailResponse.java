package com.example.be_likelion_kwu_homepage.project.dto.response;
import com.example.be_likelion_kwu_homepage.project.entity.Project;
import java.util.List;
public record ProjectDetailResponse(Long id, String title, String tag, String description, String generation,
                                    String activity, String overview, List<String> features, List<String> images) {
    public static ProjectDetailResponse from(Project project, List<String> features, List<String> images) {
        return new ProjectDetailResponse(project.getId(), project.getTitle(), project.getCategory() == null ? null : project.getCategory().name(),
                project.getDescription() == null ? project.getSubTitle() : project.getDescription(), project.getGeneration(),
                project.getActivity() == null ? null : project.getActivity().getValue(), project.getContent(), features, images);
    }
}
