package com.nesGS.todoapp.mapper;


// Interface genérica, cuyo propósito es tomar una entrada de tipo I
// y transformarla en una salida de tipo O.
public interface IMapper <I, O>{

    // Método que implementa la funcionalidad
    public O map(I in);
}
