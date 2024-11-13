package com.nesGS.todoapp.service;

import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task){

        return null;
    }
}

// 32:39 nuevo pakete DTO