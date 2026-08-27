package com.example.be_likelion_kwu_homepage.project.controller;
import com.example.be_likelion_kwu_homepage.project.dto.response.ImageUploadResponse;
import com.example.be_likelion_kwu_homepage.project.global.dto.ApiResponse;
import com.example.be_likelion_kwu_homepage.project.global.exception.ResponseCode;
import com.example.be_likelion_kwu_homepage.project.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController @RequiredArgsConstructor @RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;
    @PostMapping(consumes = "multipart/form-data") public ResponseEntity<ApiResponse<ImageUploadResponse>> upload(@RequestPart("file") MultipartFile file) {
        return ResponseEntity.status(ResponseCode.CREATED.getStatus()).body(ApiResponse.success(ResponseCode.CREATED, new ImageUploadResponse(imageService.upload(file))));
    }
}
