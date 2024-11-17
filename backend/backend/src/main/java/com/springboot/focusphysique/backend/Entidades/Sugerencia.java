package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Sugerencia")
public class Sugerencia {
    @Id
    @Column(name = "Id_sugerencia")
    private Integer idSugerencia;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Tipo_sugerencia")
    private String tipoSugerencia;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento", referencedColumnName = "Id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "Id_rutina", referencedColumnName = "Id_rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}