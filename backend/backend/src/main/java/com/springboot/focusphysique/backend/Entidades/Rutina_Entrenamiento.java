package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Rutina_Entrenamiento")
public class Rutina_Entrenamiento {
    @Id
    @Column(name = "Id_rutina")
    private Integer idRutina;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Duracion")
    private String duracion;

    @Column(name = "Lv_dificultad")
    private String nivelDificultad;
}
