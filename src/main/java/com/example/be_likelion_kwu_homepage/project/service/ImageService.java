package com.example.be_likelion_kwu_homepage.project.service;
import com.example.be_likelion_kwu_homepage.project.global.exception.*;
import io.awspring.cloud.s3.ObjectMetadata;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;
@Service @RequiredArgsConstructor
public class ImageService {
    private static final long MAX_FILE_SIZE = 10L * 1024 * 1024;
    private final S3Template s3Template;
    @Value("${app.s3.bucket:}") private String bucket;
    @Value("${app.s3.public-base-url:}") private String publicBaseUrl;
    public String upload(MultipartFile file) {
        if (file == null || file.isEmpty() || file.getContentType() == null || !file.getContentType().startsWith("image/")) throw new BusinessException(ResponseCode.INVALID_IMAGE_FILE);
        if (file.getSize() > MAX_FILE_SIZE) throw new BusinessException(ResponseCode.FILE_SIZE_EXCEEDED);
        if (bucket.isBlank()) throw new BusinessException(ResponseCode.S3_UPLOAD_FAILED);
        String key = "images/" + UUID.randomUUID() + extension(file.getOriginalFilename());
        try {
            s3Template.upload(bucket, key, file.getInputStream(), ObjectMetadata.builder().contentType(file.getContentType()).contentLength(file.getSize()).build());
            String base = publicBaseUrl.isBlank() ? "https://" + bucket + ".s3.amazonaws.com" : publicBaseUrl.replaceAll("/$", "");
            return base + "/" + key;
        } catch (IOException | RuntimeException e) { throw new BusinessException(ResponseCode.S3_UPLOAD_FAILED); }
    }
    private String extension(String filename) { if (filename == null) return ""; int i = filename.lastIndexOf('.'); return i < 0 ? "" : filename.substring(i); }
}
