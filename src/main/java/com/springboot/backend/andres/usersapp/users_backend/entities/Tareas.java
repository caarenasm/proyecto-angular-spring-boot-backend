package com.springboot.backend.andres.usersapp.users_backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tareas")
@Data
public class Tareas {

    @Id
    @Column(name = "client_id")
    private String clientId; // camelCase
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "completed")
    private Boolean completed;
}
