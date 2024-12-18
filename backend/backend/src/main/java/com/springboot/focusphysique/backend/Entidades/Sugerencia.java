package com.springboot.focusphysique.backend.Entidades;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sugerencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSugerencia;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Tipo_Sugerencia tipoSugerencia;


    @ManyToMany(mappedBy = "sugerencias", cascade = {CascadeType.MERGE}) // Aquí referenciamos la propiedad 'sugerencias' de Entrenamiento
    private Set<Entrenamiento> Entrenamiento = new HashSet<>();

    @ManyToMany(mappedBy = "sugerencias", cascade = {CascadeType.MERGE}) // Aquí referenciamos la propiedad 'sugerencias' de Entrenamiento
    private Set<Rutina_Entrenamiento> rutina_Entrenamientos = new HashSet<>();

}