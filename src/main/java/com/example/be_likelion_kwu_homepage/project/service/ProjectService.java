package com.example.be_likelion_kwu_homepage.project.service;
import com.example.be_likelion_kwu_homepage.project.domain.*;
import com.example.be_likelion_kwu_homepage.project.dto.request.*;
import com.example.be_likelion_kwu_homepage.project.dto.response.*;
import com.example.be_likelion_kwu_homepage.project.entity.Project;
import com.example.be_likelion_kwu_homepage.project.global.exception.*;
import com.example.be_likelion_kwu_homepage.project.repository.ProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service @RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository; private final ObjectMapper objectMapper;
    @Transactional public Long create(CreateProjectRequest req) {
        Project p = Project.create(req.title(), req.description(), req.overview(), ProjectCategory.valueOf(req.tag()), req.generation(),
                ProjectActivity.from(req.activity()), write(req.features()), write(req.images()), req.images().get(0));
        return projectRepository.save(p).getId();
    }
    public List<ProjectSummaryResponse> getAllProjects() { return projectRepository.findAllByOrderByIdDesc().stream().map(ProjectSummaryResponse::from).toList(); }
    public ProjectDetailResponse getOneProject(Long id) { Project p = projectRepository.findById(id).orElseThrow(InvalidProjectIdException::new); return ProjectDetailResponse.from(p, read(p.getFeatures()), readImages(p)); }
    @Transactional public UpdateProjectResponse updateProject(Long id, UpdateProjectRequest req) { Project p = projectRepository.findById(id).orElseThrow(InvalidProjectIdException::new); p.update(req.title(), req.subTitle(), req.content(), req.imageUrl(), req.category(), req.generation()); return UpdateProjectResponse.from(p); }
    private String write(List<String> values) { try { return objectMapper.writeValueAsString(values); } catch (JsonProcessingException e) { throw new BusinessException(ResponseCode.JSON_PROCESSING_FAILED); } }
    private List<String> read(String value) { if (value == null || value.isBlank()) return List.of(); try { return objectMapper.readValue(value, new TypeReference<>() {}); } catch (JsonProcessingException e) { throw new BusinessException(ResponseCode.JSON_PROCESSING_FAILED); } }
    private List<String> readImages(Project p) { List<String> images = read(p.getImages()); return images.isEmpty() && p.getImageUrl() != null ? List.of(p.getImageUrl()) : images; }
}
