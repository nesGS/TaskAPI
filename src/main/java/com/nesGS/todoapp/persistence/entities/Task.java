package com.nesGS.todoapp.persistence.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String title;
    private  String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;  // Fecha estimada de terminación
    private boolean finished;
    private TaskStatus taskStatus;  // ON_TIME o LATE (Enum)
}
