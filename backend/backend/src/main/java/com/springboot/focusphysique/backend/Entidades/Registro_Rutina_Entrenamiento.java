package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Registro_Rutina_Entrenamiento {
    @Id
    private Integer idRegRutinaEntren;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "Id_Rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}
