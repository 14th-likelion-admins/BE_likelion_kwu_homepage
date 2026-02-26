package com.example.be_likelion_kwu_homepage.project.service;

import com.example.be_likelion_kwu_homepage.project.dto.request.CreateRequest;
import com.example.be_likelion_kwu_homepage.project.dto.request.UpdateProjectRequest;
import com.example.be_likelion_kwu_homepage.project.dto.response.DetailResponse;
import com.example.be_likelion_kwu_homepage.project.dto.response.ListResponse;
import com.example.be_likelion_kwu_homepage.project.dto.response.UpdateProjectResponse;
import com.example.be_likelion_kwu_homepage.project.entity.Project;
import com.example.be_likelion_kwu_homepage.project.global.exception.InvalidProjectIdException;
import com.example.be_likelion_kwu_homepage.project.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    // 프로젝트 아카이브 생성 로직
    @Transactional // 트랜잭션 : 예외 발생 -> 전체 롤백, 정상 종료 -> 커밋
    public Long create(CreateRequest req){
        Project project = Project.create(
                req.title(),
                req.subTitle(),
                req.content(),
                req.imageUrl(),
                req.category(),
                req.generation()
        );

       Project saved = projectRepository.save(project);
       return saved.getId();
    }

    // 프로젝트 아카이브 전체조회 로직
    public List<ListResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ListResponse::from)
                .toList();
    }

    // 프로젝트 아카이브 상세조회 로직
    public DetailResponse getOneProject(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(InvalidProjectIdException::new);

        return DetailResponse.from(project);
    }

    // 프로젝트 아카이브 수정 로직
    @Transactional
    public UpdateProjectResponse updateProject(Long id, UpdateProjectRequest req) {

        Project project = projectRepository.findById(id)
                .orElseThrow(InvalidProjectIdException::new);

        project.update(
                req.title(),
                req.subTitle(),
                req.content(),
                req.imageUrl(),
                req.category(),
                req.generation()
        );

        return UpdateProjectResponse.from(project);
    }

}
