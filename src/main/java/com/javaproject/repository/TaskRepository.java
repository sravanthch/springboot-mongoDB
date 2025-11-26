package com.javaproject.repository;

import com.javaproject.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity); //Spring is good enough to understand this method

    @Query("{assignee: ?0 }")
    List<Task>  getTasksByAssignee(String assignee);
}
