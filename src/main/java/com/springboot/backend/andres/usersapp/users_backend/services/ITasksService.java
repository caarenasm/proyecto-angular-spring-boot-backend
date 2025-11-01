package com.springboot.backend.andres.usersapp.users_backend.services;

import com.springboot.backend.andres.usersapp.users_backend.dto.TareasDto;

import java.util.List;

public interface ITasksService {
    List<TareasDto> getTareas();
    TareasDto crearTareas(TareasDto tareasDto);
    TareasDto editarTareas(TareasDto tareasDto);
    TareasDto borrarTareas(TareasDto tareasDto);
}
