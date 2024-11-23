package com.springboot.focusphysique.backend.Entidades;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;



@Data
@Entity
public class Registro_progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegProgreso;
    private Date fecha;
    private Integer pesoMaxLevantado;
    private Double alturaActual;
    private Double pesoActual;

    @ManyToOne // Relación Muchos a Uno
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; // Una cuenta por usuario
}
