package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Sugerencia {
    @Id
    private Integer idSugerencia;
    private String descripcion;
    private String tipoSugerencia;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "Id_rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}