package com.ermanp.issuemanagement.service.impl;

import com.ermanp.issuemanagement.dto.ProjectDto;
import com.ermanp.issuemanagement.entity.Project;
import com.ermanp.issuemanagement.repository.ProjectRepository;
import com.ermanp.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Project save(Project project) {
        try {
            Optional.of(project)
                    .map(Project::getProjectName);
        }catch (Exception e){
            throw new IllegalArgumentException("Project code cannot be null!");
        }
        return projectRepository.save(project);
    }

    @Override
    public ProjectDto getById(Long id) {
        Project project = projectRepository.getOne(id);
        ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);
        return projectDto;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
