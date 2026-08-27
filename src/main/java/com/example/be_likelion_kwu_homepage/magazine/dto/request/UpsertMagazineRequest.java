package com.example.be_likelion_kwu_homepage.magazine.dto.request;

import com.example.be_likelion_kwu_homepage.magazine.dto.BlockDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record UpsertMagazineRequest(
        @NotBlank String title,
        @NotEmpty List<@Valid BlockDto> blocks
) {}
