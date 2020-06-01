package com.ermanp.issuemanagement.service;

import com.ermanp.issuemanagement.dto.ProjectDto;
import com.ermanp.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    ProjectDto getById(Long id);

    Page<Project> getAllPageable(Pageable pageable);

    List<Project> getByProjectCodeContains(String projectCode);

    Boolean delete(Project project);
}
