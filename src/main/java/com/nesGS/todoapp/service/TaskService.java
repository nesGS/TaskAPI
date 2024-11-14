package com.nesGS.todoapp.service;

import com.nesGS.todoapp.mapper.TaskInDTOToTask;
import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.repository.TaskRepository;
import com.nesGS.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

/*----------------------------------------------------------------- */

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}

