package com.example.be_likelion_kwu_homepage.project.entity;

import com.example.be_likelion_kwu_homepage.project.domain.ProjectCategory;
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
    private Long id; // 프로젝트 ID

    @Column(nullable = false, length = 100) // null 불가, 길이 100자 제한
    private String title; // 프로젝트 제목

    @Column(nullable = false, length = 100)
    private String subTitle; // 프로젝트 부제목

    @Column(nullable = false, columnDefinition = "TEXT", length = 500) // 텍스트 형식으로 컬럼 정의
    private String content; // 프로젝트 내용

    @Column(length = 500)
    private String imageUrl; // 프로젝트 썸네일 url

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectCategory category; // 프로젝트 분류

    @Column
    private Integer generation; // 멋사 기수

    // 엔티티 생성자
    protected Project(String title, String subTitle, String content, String imageUrl, ProjectCategory category, Integer generation) {
        this.title = title;
        this.subTitle = subTitle;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
        this.generation = generation;
    }

    // 생성자를 통제하기 위한 정적 팩토리 메서드
    public static Project create(String title, String subTitle, String content, String imageUrl, ProjectCategory category, Integer generation) {
        return new Project(title, subTitle, content, imageUrl, category, generation);
    }

}
