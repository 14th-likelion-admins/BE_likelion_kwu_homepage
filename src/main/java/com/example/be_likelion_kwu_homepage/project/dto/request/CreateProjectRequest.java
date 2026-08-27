package com.example.be_likelion_kwu_homepage.project.dto.request;

import jakarta.validation.constraints.*;
import java.util.List;

public record CreateProjectRequest(
        @NotBlank @Size(max = 100) String title,
        @NotBlank @Pattern(regexp = "WEB|APP") String tag,
        @NotBlank @Size(max = 200) String description,
        @NotBlank String generation,
        @NotBlank @Pattern(regexp = "아이디어톤|중앙해커톤|권역별 연합해커톤") String activity,
        @NotBlank String overview,
        @NotEmpty List<@NotBlank String> features,
        @NotEmpty @Size(min = 1, max = 10) List<@NotBlank String> images
) {}
