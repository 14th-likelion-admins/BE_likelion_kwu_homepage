package com.example.be_likelion_kwu_homepage.project.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 안정성 고려
@Table(name = "projects")
public class Project {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId; // 프로젝트 ID

    @Column(nullable = false, length = 100) // null 불가, 길이 100자 제한
    private String title; // 프로젝트 제목

    @Column(nullable = false, length = 100)
    private String subTitle; // 프로젝트 부제목

    @Lob // DB 종속성을 고려해서 사용 -> content를 TEXT 형식으로 하려고 사용
    @Column(nullable = false)
    private String content; // 프로젝트 내용

    @Column(length = 500)
    private String imageUrl; // 프로젝트 썸네일 url

    @Column
    private String category; // 프로젝트 분류

    @Column
    private Long generation; // 멋사 기수

    // 엔티티 생성자
    public Project(String title, String subTitle, String content, String imageUrl, String category, Long generation) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
        this.generation = generation;
    }
}
