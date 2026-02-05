package com.example.be_likelion_kwu_homepage.project.dto.request;


import com.example.be_likelion_kwu_homepage.project.entity.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateRequest(
        @NotBlank
        String title,

        @NotBlank
        String subTitle,

        @NotBlank
        String content,

        @Size(max = 500)
        String imageUrl,

        @NotNull
        Project.ProjectCategory category,

        @NotNull
        Integer generation
){}