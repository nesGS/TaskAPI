package com.nesGS.todoapp.service.dto;


import lombok.Data;

import java.time.LocalDateTime;

// Esta clase establece los datos que le vamos a pedir al usuario para la creación de una tarea (Task),
// olvidándonos de datos de la clase principal que no son relevantes para el usuario durante la creación.
@Data
public class TaskInDTO {
    private  String title;
    private  String description;
    private LocalDateTime eta;
}
