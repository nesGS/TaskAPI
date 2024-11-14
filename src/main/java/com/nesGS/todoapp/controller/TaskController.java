package com.nesGS.todoapp.controller;

import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.entities.TaskStatus;
import com.nesGS.todoapp.service.TaskService;
import com.nesGS.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    // Inyectamos el servicio + constructor.
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


/*----------------------------------------------------------------- */
/*-------------IMPLEMENTACIÓN DE LOS MÉTODOS----------------------- */
/*----------------------------------------------------------------- */

    // Crea una tarea a través de los datos introducidos por el usuario en taskInDTO.
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    // Solicita todas las tareas guardadas.
    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    // Solicita todas las tareas del "status" que se especifica.
    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable ("status")TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    // Actualiza el estado de una tarea a "finished".
    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id) {
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    // Elimina la tarea con el "id" que se especifica.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
