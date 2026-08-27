package com.example.be_likelion_kwu_homepage.magazine.dto.response;

import com.example.be_likelion_kwu_homepage.magazine.entity.Magazine;

public record MagazineSummaryResponse(Integer generation, String title) {
    public static MagazineSummaryResponse from(Magazine magazine) {
        return new MagazineSummaryResponse(magazine.getGeneration(), magazine.getTitle());
    }
}
