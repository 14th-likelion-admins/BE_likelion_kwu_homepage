package com.example.be_likelion_kwu_homepage.project.global.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
@Configuration public class CorsConfig implements WebMvcConfigurer {
    @Override public void addCorsMappings(CorsRegistry registry) { registry.addMapping("/api/**").allowedOrigins("http://localhost:5173", "https://www.likelion-kwu.com").allowedMethods("GET", "POST", "PATCH", "OPTIONS").allowedHeaders("*"); }
}
