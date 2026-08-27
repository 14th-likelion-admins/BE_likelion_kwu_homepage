package com.example.be_likelion_kwu_homepage.magazine.entity;

import com.example.be_likelion_kwu_homepage.magazine.domain.ActivityType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "magazines", uniqueConstraints = @UniqueConstraint(columnNames = {"activity_type", "generation"}))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Magazine {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activityType;

    @Column(nullable = false)
    private Integer generation;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String blocksJson;

    protected Magazine(ActivityType activityType, Integer generation, String title, String blocksJson) {
        this.activityType = activityType;
        this.generation = generation;
        this.title = title;
        this.blocksJson = blocksJson;
    }

    public static Magazine create(ActivityType activityType, Integer generation, String title, String blocksJson) {
        return new Magazine(activityType, generation, title, blocksJson);
    }

    public void update(String title, String blocksJson) {
        this.title = title;
        this.blocksJson = blocksJson;
    }
}
