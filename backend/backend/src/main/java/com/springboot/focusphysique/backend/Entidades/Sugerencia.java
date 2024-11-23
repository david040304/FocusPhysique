package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Sugerencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSugerencia;
    private String descripcion;
    private String tipoSugerencia;

    @ManyToOne
    @JoinColumn(name = "idEntrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_Rutina")
    private Rutina_Entrenamiento rutina_Entrenamiento;
}