package com.example.be_likelion_kwu_homepage.magazine.service;

import com.example.be_likelion_kwu_homepage.magazine.domain.ActivityType;
import com.example.be_likelion_kwu_homepage.magazine.dto.BlockDto;
import com.example.be_likelion_kwu_homepage.magazine.dto.request.UpsertMagazineRequest;
import com.example.be_likelion_kwu_homepage.magazine.dto.response.MagazineDetailResponse;
import com.example.be_likelion_kwu_homepage.magazine.dto.response.MagazineSummaryResponse;
import com.example.be_likelion_kwu_homepage.magazine.entity.Magazine;
import com.example.be_likelion_kwu_homepage.magazine.repository.MagazineRepository;
import com.example.be_likelion_kwu_homepage.project.global.exception.MagazineNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MagazineService {
    private final MagazineRepository magazineRepository;
    private final ObjectMapper objectMapper;

    public List<MagazineSummaryResponse> listGenerations(ActivityType activityType) {
        return magazineRepository.findByActivityType(activityType).stream()
                .sorted(Comparator.comparing(Magazine::getGeneration).reversed())
                .map(MagazineSummaryResponse::from)
                .toList();
    }

    public MagazineDetailResponse getMagazine(ActivityType activityType, Integer generation) {
        Magazine magazine = magazineRepository.findByActivityTypeAndGeneration(activityType, generation)
                .orElseThrow(MagazineNotFoundException::new);
        return MagazineDetailResponse.from(magazine, deserializeBlocks(magazine.getBlocksJson()));
    }

    @Transactional
    public Long upsertMagazine(ActivityType activityType, Integer generation, UpsertMagazineRequest request) {
        String blocksJson = serializeBlocks(request.blocks());
        return magazineRepository.findByActivityTypeAndGeneration(activityType, generation)
                .map(magazine -> { magazine.update(request.title(), blocksJson); return magazine.getId(); })
                .orElseGet(() -> magazineRepository.save(Magazine.create(activityType, generation, request.title(), blocksJson)).getId());
    }

    private String serializeBlocks(List<BlockDto> blocks) {
        try { return objectMapper.writeValueAsString(blocks); }
        catch (JsonProcessingException e) { throw new IllegalStateException("Unable to serialize magazine blocks.", e); }
    }

    private List<BlockDto> deserializeBlocks(String blocksJson) {
        try { return objectMapper.readValue(blocksJson, new TypeReference<>() {}); }
        catch (JsonProcessingException e) { throw new IllegalStateException("Unable to deserialize magazine blocks.", e); }
    }
}
