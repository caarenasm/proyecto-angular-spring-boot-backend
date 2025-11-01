package com.springboot.backend.andres.usersapp.users_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TareasDto {

    @JsonProperty("client_id")
    private String clientId; // igual que la entidad
    private String title;
    private String description;
    private Boolean completed;
}
