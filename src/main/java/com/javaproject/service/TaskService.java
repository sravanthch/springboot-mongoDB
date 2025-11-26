package com.javaproject.service;

import com.javaproject.model.Task;
import com.javaproject.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;


    //Create
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    //Read
    public List<Task> findAllTasks(){
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return repository.findBySeverity(severity);
        // want to search with one more parameter findBySeverityAndStoryPoint
    }

    public List<Task> getTaskByAssignee(String assignee){
        return repository.getTasksByAssignee(assignee);
        //Alternate way - something like query
        //Need to add a method manually in repository class
    }

    //Update
    public Task updateTask(Task taskRequest){
        //get the existing document from DB
        //replace new value from request to existing object/entity/document
        Task existingTask =  repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return repository.save(existingTask); //Update operation

    }

    //Delete
    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "task deleted from dashboard ";
    }
}
