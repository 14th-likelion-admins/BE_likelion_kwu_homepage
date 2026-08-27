package com.example.be_likelion_kwu_homepage.project.repository;

import com.example.be_likelion_kwu_homepage.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOrderByIdDesc();
}
