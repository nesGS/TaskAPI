package com.nesGS.todoapp.mapper;

import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.entities.TaskStatus;
import com.nesGS.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;



// Component nos permite inyectar en nuestras clases
@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {


    // Este método mapea un elemento de entrada "TaskInDTO" a uno de salida "Task",
    // a través de la implementación de nuestra interface "IMapper".
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
