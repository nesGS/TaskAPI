package com.nesGS.todoapp.mapper;

import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.entities.TaskStatus;
import com.nesGS.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


// Esta clase es un Mapper que mapea un elemento de entrada "IMapper" a uno de salida "Task"
@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {


    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
