package com.nesGS.todoapp.service;

import com.nesGS.todoapp.exceptions.ToDoExceptions;
import com.nesGS.todoapp.mapper.TaskInDTOToTask;
import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.entities.TaskStatus;
import com.nesGS.todoapp.persistence.repository.TaskRepository;
import com.nesGS.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    // Inyectando el repositorio y el mapper + constructor (sustituible por @Autowired)
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

/*----------------------------------------------------------------- */
/*-------------IMPLEMENTACIÓN DE LOS MÉTODOS----------------------- */
/*----------------------------------------------------------------- */

    // Este método se encarga de crear una "Task" a través de un parametro de entrada "TaskInDTO",
    // convirtiendo "taskInDTO" en un "Task" a través de nuestra clase mapper "TaskInDTOToTask".
    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    // Busca y trae todas las tareas de la DB.
    public List<Task> findAll() {
        return this.repository.findAll();
    }

    // Busca y trae las tareas del "status" correspondiente, a través del método de repositorio
    // implementado "findAllByTaskStatus" con query JPA.
    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    // Comprueba la existencia de una tarea, para luego cambiar su estado como "finished",
    // en caso de no existir la tarea, lanza una excepción "ToDoExceptions".
    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsFinish(id);
    }

    // Comprueba si existe la tarea para luego eliminarla.
    @Transactional
    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }

    /*
    * @Transactional es necesario en este tipo de métodos para garantizar que todas las
    * operaciones de lectura y escritura se realicen de manera segura, consistente y
    * eficiente dentro de una misma transacción.
    */


}

