package com.springboot.backend.andres.usersapp.users_backend.services;

import com.springboot.backend.andres.usersapp.users_backend.dto.TareasDto;
import com.springboot.backend.andres.usersapp.users_backend.entities.Tareas;
import com.springboot.backend.andres.usersapp.users_backend.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService implements ITasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public List<TareasDto> getTareas() {
        var data = this.tasksRepository.findAll();
        return data.stream().map(this::getTareasDto).toList();
    }

    private TareasDto getTareasDto(Tareas tareas) {
        TareasDto dto = new TareasDto();
        dto.setClientId(tareas.getClientId());
        dto.setTitle(tareas.getTitle());
        dto.setDescription(tareas.getDescription());
        dto.setCompleted(tareas.getCompleted());
        return dto;
    }

    private Tareas getTareasEntity(TareasDto dto) {
        Tareas tareas = new Tareas();
        tareas.setClientId(dto.getClientId());
        tareas.setTitle(dto.getTitle());
        tareas.setDescription(dto.getDescription());
        tareas.setCompleted(dto.getCompleted());
        return tareas;
    }

    @Override
    public TareasDto crearTareas(TareasDto tareasDto) {
        Tareas tareas = getTareasEntity(tareasDto);
        Tareas saved = tasksRepository.save(tareas);
        return getTareasDto(saved);
    }

    @Override
    public TareasDto editarTareas(TareasDto tareasDto) {
        Optional<Tareas> optionalTarea = tasksRepository.findById(tareasDto.getClientId());
        if (optionalTarea.isPresent()) {
            Tareas tarea = optionalTarea.get();
            tarea.setTitle(tareasDto.getTitle());
            tarea.setDescription(tareasDto.getDescription());
            tarea.setCompleted(tareasDto.getCompleted());
            Tareas updated = tasksRepository.save(tarea);
            return getTareasDto(updated);
        }
        return null;
    }

    @Override
    public TareasDto borrarTareas(TareasDto tareasDto) {
        Optional<Tareas> optionalTarea = tasksRepository.findById(tareasDto.getClientId());
        if (optionalTarea.isPresent()) {
            Tareas tarea = optionalTarea.get();
            tasksRepository.delete(tarea);
            return getTareasDto(tarea);
        }
        return null;
    }
}