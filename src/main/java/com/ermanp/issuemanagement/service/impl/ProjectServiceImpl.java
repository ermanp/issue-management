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
    public ProjectDto save(ProjectDto project) {
        Project projectCheck = getByProjectCode(project.getProjectCode());
        if(projectCheck != null){
            throw new IllegalArgumentException("Project Code Already Exist");
        }

        Project p = modelMapper.map(project, Project.class);
        p = projectRepository.save(p);
        project.setId(p.getId());
        return project;
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

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto project) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(project.getProjectCode(), id);
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        projectDb.setProjectCode(project.getProjectCode());
        projectDb.setProjectName(project.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAll() {
        return null;
    }

}
