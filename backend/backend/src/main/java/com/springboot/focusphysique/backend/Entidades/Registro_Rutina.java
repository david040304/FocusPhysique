package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Registro_Rutina {
    @Id
    private Integer idRegRutina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Usuario")
    private Usuario usuario;
}