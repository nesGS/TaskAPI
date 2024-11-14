package com.nesGS.todoapp.persistence.repository;

import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    // "Query Method" de Spring Data JPA para buscar tareas por su estado.
    public List<Task> findAllByTaskStatus(TaskStatus status);



    // "Consulta nativa" (directo al motor de DB) para modificar el campo "finished"
    // de una tarea (task)  a true.
    @Modifying // @Modifiying indica que es una query de actualización.
    @Query(value = "UPDATE task SET finished=true WHERE id=:id;", nativeQuery = true)
    public void markTaskAsFinish(@Param("id")Long id);


    /*
    * En Spring Data JPA, cuando usas nativeQuery = true en la anotación @Query,
    * estás indicando que la consulta está escrita en SQL nativo, en lugar de en JPQL
    * (Java Persistence Query Language). Esto significa que la consulta se ejecutará
    * directamente en el motor de base de datos subyacente, tal cual está escrita,
    * sin pasar por las abstracciones de JPA.
    */

}
