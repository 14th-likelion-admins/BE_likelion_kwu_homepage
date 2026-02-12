package com.example.be_likelion_kwu_homepage.project.controller;

import com.example.be_likelion_kwu_homepage.project.dto.request.CreateRequest;
import com.example.be_likelion_kwu_homepage.project.dto.response.ListResponse;
import com.example.be_likelion_kwu_homepage.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final 필드(ProjectService)를 생성자로 자동 주입
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    // 프로젝트 아카이브 생성
    @PostMapping
    public ResponseEntity<Long> createProject(@Valid @RequestBody CreateRequest req) { // DTO에 정의된 유효성 검사 규칙을 실행
        Long id = projectService.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    // 프로젝트 아카이브 전체조회
    @GetMapping
    public ResponseEntity<List<ListResponse>> getAllProjects() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(projectService.getAllProjects());
    }
}
