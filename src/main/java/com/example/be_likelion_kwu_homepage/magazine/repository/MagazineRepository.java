package com.example.be_likelion_kwu_homepage.magazine.repository;

import com.example.be_likelion_kwu_homepage.magazine.domain.ActivityType;
import com.example.be_likelion_kwu_homepage.magazine.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    List<Magazine> findByActivityType(ActivityType activityType);
    Optional<Magazine> findByActivityTypeAndGeneration(ActivityType activityType, Integer generation);
}
