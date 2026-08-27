package com.example.be_likelion_kwu_homepage.magazine.controller;

import com.example.be_likelion_kwu_homepage.magazine.domain.ActivityType;
import com.example.be_likelion_kwu_homepage.magazine.dto.request.UpsertMagazineRequest;
import com.example.be_likelion_kwu_homepage.magazine.dto.response.MagazineDetailResponse;
import com.example.be_likelion_kwu_homepage.magazine.dto.response.MagazineSummaryResponse;
import com.example.be_likelion_kwu_homepage.magazine.service.MagazineService;
import com.example.be_likelion_kwu_homepage.project.global.dto.ApiResponse;
import com.example.be_likelion_kwu_homepage.project.global.exception.ResponseCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/magazines")
public class MagazineController {
    private final MagazineService magazineService;

    @GetMapping("/{activityType}")
    public ResponseEntity<ApiResponse<List<MagazineSummaryResponse>>> listGenerations(@PathVariable ActivityType activityType) {
        return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, magazineService.listGenerations(activityType)));
    }

    @GetMapping("/{activityType}/{generation}")
    public ResponseEntity<ApiResponse<MagazineDetailResponse>> getMagazine(@PathVariable ActivityType activityType, @PathVariable Integer generation) {
        return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, magazineService.getMagazine(activityType, generation)));
    }

    @PutMapping("/{activityType}/{generation}")
    public ResponseEntity<ApiResponse<Long>> upsertMagazine(@PathVariable ActivityType activityType, @PathVariable Integer generation, @Valid @RequestBody UpsertMagazineRequest request) {
        return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, magazineService.upsertMagazine(activityType, generation, request)));
    }
}
