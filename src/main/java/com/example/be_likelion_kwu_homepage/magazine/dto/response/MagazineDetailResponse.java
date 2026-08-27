package com.example.be_likelion_kwu_homepage.magazine.dto.response;

import com.example.be_likelion_kwu_homepage.magazine.domain.ActivityType;
import com.example.be_likelion_kwu_homepage.magazine.dto.BlockDto;
import com.example.be_likelion_kwu_homepage.magazine.entity.Magazine;
import java.util.List;

public record MagazineDetailResponse(Long id, ActivityType activityType, Integer generation, String title, List<BlockDto> blocks) {
    public static MagazineDetailResponse from(Magazine magazine, List<BlockDto> blocks) {
        return new MagazineDetailResponse(magazine.getId(), magazine.getActivityType(), magazine.getGeneration(), magazine.getTitle(), blocks);
    }
}
