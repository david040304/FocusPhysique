package com.springboot.focusphysique.backend.Dto;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rutina_EntrenamientoDto {
    private Integer idRutina;
    private String nombre;
    private String descripcion;
    private Time duracion;
    private String nivel_Dificultad;
}
