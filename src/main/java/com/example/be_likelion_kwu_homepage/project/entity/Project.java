package com.example.be_likelion_kwu_homepage.project.entity;

import com.example.be_likelion_kwu_homepage.project.domain.ProjectActivity;
import com.example.be_likelion_kwu_homepage.project.domain.ProjectCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    // Retained for data created by the previous API.
    @Column(length = 100)
    private String subTitle;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(length = 500)
    private String imageUrl;
    @Enumerated(EnumType.STRING) @Column
    private ProjectCategory category;
    private String generation;
    @Column(length = 200)
    private String description;
    @Enumerated(EnumType.STRING) @Column(length = 30)
    private ProjectActivity activity;
    @Column(columnDefinition = "TEXT")
    private String features;
    @Column(columnDefinition = "TEXT")
    private String images;

    protected Project(String title, String subTitle, String content, String imageUrl, ProjectCategory category, String generation) {
        this.title = title; this.subTitle = subTitle; this.content = content; this.imageUrl = imageUrl;
        this.category = category; this.generation = generation;
    }
    protected Project(String title, String description, String overview, ProjectCategory category, String generation,
                      ProjectActivity activity, String features, String images, String imageUrl) {
        this.title = title; this.description = description; this.content = overview; this.category = category;
        this.generation = generation; this.activity = activity; this.features = features; this.images = images;
        this.imageUrl = imageUrl;
    }
    public static Project create(String title, String subTitle, String content, String imageUrl, ProjectCategory category, String generation) {
        return new Project(title, subTitle, content, imageUrl, category, generation);
    }
    public static Project create(String title, String description, String overview, ProjectCategory category, String generation,
                                 ProjectActivity activity, String features, String images, String imageUrl) {
        return new Project(title, description, overview, category, generation, activity, features, images, imageUrl);
    }
    public void update(String title, String subTitle, String content, String imageUrl, ProjectCategory category, String generation) {
        this.title = title; this.subTitle = subTitle; this.content = content; this.imageUrl = imageUrl;
        this.category = category; this.generation = generation;
    }
}
