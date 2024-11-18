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
@Table(name = "Entrenamiento")
public class Entrenamiento {
    @Id
    @Column(name = "Id_entrenamiento")
    private Integer idEntrenamiento;

    @Column(name = "Nombre_entrenamiento")
    private String nombreEntrenamiento;

    @Column(name = "Descripcion_entre")
    private String descripcionEntrenamiento;

    @Column(name = "Grupo_Muscular")
    private String grupoMuscular;

    @Column(name = "Lv_dificultad")
    private String nivelDificultad;

    @Column(name = "Genero")
    private Character genero;

    @Column(name = "MET")
    private Double met;

    @ManyToOne
    @JoinColumn(name = "Id_Tipo_Entren", referencedColumnName = "Id_Tipo_Entren")
    private Tipo_de_Entrenamiento tipoDeEntrenamiento;
}
