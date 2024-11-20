package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Registro_Entrenamiento {
    @Id
    private Integer idRegEnt;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento")
    private Entrenamiento entrenamiento;
}
