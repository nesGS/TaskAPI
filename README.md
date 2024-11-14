### NesGS - *(Mappers y DTOs)*
# ToDo API

## Descripción
_ToDoApp_ es una API para la gestión de tareas que permite a los usuarios crear, consultar, actualizar y eliminar tareas. 
Cada tarea tiene un estado (`TaskStatus`) que ayuda a organizar y visualizar el progreso de los pendientes.


## Endpoints

A continuación, se detallan los endpoints disponibles en la API.

### 1. Crear una Tarea

- **Método**: `POST`
- **URL**: `/tasks`
- **Descripción**: Crea una nueva tarea utilizando la información proporcionada en el objeto `TaskInDTO`.
- **Cuerpo de la solicitud**:
  ```json
  {
    "title": "Nombre de la tarea",
    "description": "Descripción de la tarea",
    "eta": "YYYY-MM-DDTHH:MM:SS"
  }
    ```
- **Respuesta**: Retorna el objeto `Task` creado.

### 2. Obtener Todas las Tareas

- **Método**: `GET`
- **URL**: `/tasks`
- **Descripción**: Recupera una lista de todas las tareas guardadas en la aplicación.
- **Respuesta**: Retorna una lista de objetos `Task`.
### 3. Obtener Tareas por Estado

- **Método**: `GET`
- **URL**: `/tasks/status/{status}`
- **Descripción**: Obtiene una lista de tareas filtradas por el estado especificado (`status`).
- **Parámetros**:
    - `status`: Estado de la tarea (`TaskStatus`) a filtrar.
- **Respuesta**: Retorna una lista de objetos `Task` con el estado indicado.

---

### 4. Marcar una Tarea como Finalizada

- **Método**: `PATCH`
- **URL**: `/tasks/mark_as_finished/{id}`
- **Descripción**: Actualiza el estado de una tarea a "finalizado".
- **Parámetros**:
    - `id`: ID de la tarea a actualizar.
- **Respuesta**: Retorna un código `204 No Content` si la tarea se actualiza correctamente.

---

### 5. Eliminar una Tarea

- **Método**: `DELETE`
- **URL**: `/tasks/{id}`
- **Descripción**: Elimina la tarea correspondiente al ID proporcionado.
- **Parámetros**:
    - `id`: ID de la tarea a eliminar.
- **Respuesta**: Retorna un código `204 No Content` si la tarea se elimina correctamente.
