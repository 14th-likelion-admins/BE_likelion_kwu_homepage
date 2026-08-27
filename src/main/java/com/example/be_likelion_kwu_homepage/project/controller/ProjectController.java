package com.example.be_likelion_kwu_homepage.project.controller;
import com.example.be_likelion_kwu_homepage.project.dto.request.*;
import com.example.be_likelion_kwu_homepage.project.dto.response.*;
import com.example.be_likelion_kwu_homepage.project.global.dto.ApiResponse;
import com.example.be_likelion_kwu_homepage.project.global.exception.ResponseCode;
import com.example.be_likelion_kwu_homepage.project.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequiredArgsConstructor @RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;
    // TODO: 등록 API는 추후 인증 필요
    @PostMapping public ResponseEntity<ApiResponse<Long>> createProject(@Valid @RequestBody CreateProjectRequest req) { return ResponseEntity.status(ResponseCode.CREATED.getStatus()).body(ApiResponse.success(ResponseCode.CREATED, projectService.create(req))); }
    @GetMapping public ResponseEntity<ApiResponse<List<ProjectSummaryResponse>>> getAllProjects() { return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, projectService.getAllProjects())); }
    @GetMapping("/{id}") public ResponseEntity<ApiResponse<ProjectDetailResponse>> getOneProject(@PathVariable Long id) { return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, projectService.getOneProject(id))); }
    @PatchMapping("/{id}") public ResponseEntity<ApiResponse<UpdateProjectResponse>> updateProject(@PathVariable Long id, @Valid @RequestBody UpdateProjectRequest req) { return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, projectService.updateProject(id, req))); }
}
