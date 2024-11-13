package com.nesGS.todoapp.persistence.repository;

import com.nesGS.todoapp.persistence.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {
}
