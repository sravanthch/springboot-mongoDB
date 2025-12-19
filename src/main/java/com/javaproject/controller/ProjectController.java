package com.javaproject.controller;

import com.javaproject.model.Project;
import com.javaproject.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody @jakarta.validation.Valid Project project) {
        return service.addProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return service.findAllProjects();
    }
}
