package com.springboot.focusphysique.backend.Entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    @JoinColumn(name = "id_Rutina")
    private Rutina_Entrenamiento rutina_Entrenamiento;

    @ManyToMany(mappedBy = "sugerencias") // Aquí referenciamos la propiedad 'sugerencias' de Entrenamiento
    private Set<Entrenamiento> entrenamientos = new HashSet<>();

    @ManyToMany(mappedBy = "sugerencias") // Aquí referenciamos la propiedad 'sugerencias' de Entrenamiento
    private Set<Rutina_Entrenamiento> rutina_Entrenamientos = new HashSet<>();

}