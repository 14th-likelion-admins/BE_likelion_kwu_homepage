package com.example.be_likelion_kwu_homepage.image.controller;

import com.example.be_likelion_kwu_homepage.image.dto.ImageUploadResponse;
import com.example.be_likelion_kwu_homepage.project.global.dto.ApiResponse;
import com.example.be_likelion_kwu_homepage.project.global.exception.ImageUploadException;
import com.example.be_likelion_kwu_homepage.project.global.exception.InvalidImageFileException;
import com.example.be_likelion_kwu_homepage.project.global.exception.ResponseCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/images")
public class ImageUploadController {
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024;
    private final S3Client s3Client;

    @Value("${S3_BUCKET_NAME}")
    private String bucketName;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<ImageUploadResponse>> upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || file.getSize() > MAX_FILE_SIZE || file.getContentType() == null
                || !file.getContentType().toLowerCase().startsWith("image/")) {
            throw new InvalidImageFileException();
        }
        String key = "magazines/" + UUID.randomUUID() + extensionOf(file.getOriginalFilename());
        try {
            s3Client.putObject(PutObjectRequest.builder().bucket(bucketName).key(key).contentType(file.getContentType()).build(),
                    RequestBody.fromBytes(file.getBytes()));
            String url = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(key)).toExternalForm();
            return ResponseEntity.ok(ApiResponse.success(ResponseCode.OK, new ImageUploadResponse(url)));
        } catch (SdkException | java.io.IOException e) {
            throw new ImageUploadException();
        }
    }

    private String extensionOf(String originalFilename) {
        if (originalFilename == null) return "";
        int dotIndex = originalFilename.lastIndexOf('.');
        return dotIndex >= 0 ? originalFilename.substring(dotIndex).toLowerCase() : "";
    }
}
