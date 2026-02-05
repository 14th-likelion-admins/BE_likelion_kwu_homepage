package com.example.be_likelion_kwu_homepage.project.service;

import com.example.be_likelion_kwu_homepage.project.dto.request.CreateRequest;
import com.example.be_likelion_kwu_homepage.project.dto.response.CreateResponse;
import com.example.be_likelion_kwu_homepage.project.entity.Project;
import com.example.be_likelion_kwu_homepage.project.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional // 트랜잭션 : 예외 발생 -> 전체 롤백, 정상 종료 -> 커밋
    public CreateResponse create(CreateRequest req){
        Project project = Project.create(
                req.title(),
                req.subTitle(),
                req.content(),
                req.imageUrl(),
                req.category(),
                req.generation()
        );

       Project saved = projectRepository.save(project);

        return new CreateResponse(
                saved.getProjectid(),
                saved.getTitle(),
                saved.getSubTitle(),
                saved.getContent(),
                saved.getImageUrl(),
                saved.getCategory().name(),
                saved.getGeneration()
        );
    }

}
