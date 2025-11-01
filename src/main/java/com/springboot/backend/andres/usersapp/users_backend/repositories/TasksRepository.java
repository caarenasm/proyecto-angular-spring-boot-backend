package com.springboot.backend.andres.usersapp.users_backend.repositories;

import com.springboot.backend.andres.usersapp.users_backend.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Tareas, String> {
}