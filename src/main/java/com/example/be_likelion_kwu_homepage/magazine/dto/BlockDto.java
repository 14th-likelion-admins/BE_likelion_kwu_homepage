package com.example.be_likelion_kwu_homepage.magazine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record BlockDto(
        @NotBlank String id,
        @NotBlank @Pattern(regexp = "text|image") String type,
        String text,
        @Pattern(regexp = "heading|paragraph") String style,
        String url,
        String caption,
        @Pattern(regexp = "full|half") String width
) {}
