package com.nesGS.todoapp.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

// Clase genérica que indica el formato de excepciones de la aplicación.
@Data
public class ToDoExceptions extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public ToDoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
