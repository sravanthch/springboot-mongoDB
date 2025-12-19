package com.javaproject.service;

import com.javaproject.model.Project;
import com.javaproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository repository;

    public Project addProject(Project project) {
        project.setProjectId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(project);
    }

    public List<Project> findAllProjects() {
        return repository.findAll();
    }
}
