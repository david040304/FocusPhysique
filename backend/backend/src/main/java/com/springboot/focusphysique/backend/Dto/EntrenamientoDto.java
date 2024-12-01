package com.springboot.focusphysique.backend.Dto;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntrenamientoDto {
    private Integer idEntrenamiento;
    private String nombreEntrenamiento;
    private String descripcionEntrenamiento;
    private String grupoMuscular;
    private String nivelDificultad;
    private Character genero;
    private Time duracion;
    private Double met;
}
