package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Data;



@Data
@Entity
public class Registro_progreso {
    @Id
    private Integer idRegProgreso;
    private String fecha;
    private Integer pesoMaxLevantado;
    private Double alturaActual;
    private Double pesoActual;

}
