package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Registro_progreso {
    @Id
    private Integer idRegProgreso;
    private String fecha;
    private Integer pesoMaxLevantado;
    private Double alturaActual;
    private Double pesoActual;

    @ManyToOne
    @JoinColumn(name = "Id_usuario")
    private Usuario usuario;
}
