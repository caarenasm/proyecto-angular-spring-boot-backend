package com.springboot.backend.andres.usersapp.users_backend.controllers;

import com.springboot.backend.andres.usersapp.users_backend.dto.TareasDto;
import com.springboot.backend.andres.usersapp.users_backend.services.TasksService;
import com.springboot.backend.andres.usersapp.users_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaTray;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("api/tasks")
public class TasksController {
    @Autowired private TasksService tasksService;

    @GetMapping(path = "lista", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TareasDto>> getAllTasks() {
        return new ResponseEntity<>(this.tasksService.getTareas(), HttpStatus.OK);
    }

    @PostMapping(path = "crear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TareasDto> createTask(@RequestBody TareasDto tareasDto) {
        return new ResponseEntity<>(this.tasksService.crearTareas(tareasDto), HttpStatus.OK);
    }

    @PostMapping(path = "editar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TareasDto> editTask(@RequestBody TareasDto tareasDto) {
        return new ResponseEntity<TareasDto>(this.tasksService.editarTareas(tareasDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TareasDto> deleteTask(@RequestBody TareasDto tareasDto) {
        return new ResponseEntity<TareasDto>(this.tasksService.borrarTareas(tareasDto), HttpStatus.OK);
    }

    @GetMapping(path = "status", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTaskStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}