package com.example.be_likelion_kwu_homepage.project.controller;

import com.example.be_likelion_kwu_homepage.project.dto.request.CreateRequest;
import com.example.be_likelion_kwu_homepage.project.dto.response.DetailResponse;
import com.example.be_likelion_kwu_homepage.project.dto.response.ListResponse;
import com.example.be_likelion_kwu_homepage.project.global.dto.ApiResponse;
import com.example.be_likelion_kwu_homepage.project.global.exception.ResponseCode;
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
    public ResponseEntity<ApiResponse<Long>> createProject(@Valid @RequestBody CreateRequest req) { // DTO에 정의된 유효성 검사 규칙을 실행
        Long id = projectService.create(req);

        return ResponseEntity
                .status(ResponseCode.CREATED.getStatus())
                .body(ApiResponse.success(ResponseCode.CREATED, id));
    }

    // 프로젝트 아카이브 전체조회
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListResponse>>> getAllProjects() {
        List<ListResponse> data = projectService.getAllProjects();

        return ResponseEntity
                .status(ResponseCode.OK.getStatus())
                .body(ApiResponse.success(ResponseCode.OK, data));
    }


    // 프로젝트 아카이브 상세조회
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DetailResponse>> getOneProject(@PathVariable Long id) {
        DetailResponse data = projectService.getOneProject(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.success(ResponseCode.OK, data));
    }
}
