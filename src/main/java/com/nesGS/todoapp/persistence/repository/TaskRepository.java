package com.nesGS.todoapp.persistence.repository;

import com.nesGS.todoapp.persistence.entities.Task;
import com.nesGS.todoapp.persistence.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE task SET finished=true WHERE id=1;"
            ,nativeQuery = true

    )
    public void markTaskAsFinish(@Param("id")Long id);



}
