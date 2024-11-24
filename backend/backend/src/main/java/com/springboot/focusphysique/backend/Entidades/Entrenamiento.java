package com.springboot.focusphysique.backend.Entidades;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntrenamiento;
    private String nombreEntrenamiento;
    private String descripcionEntrenamiento;
    private String grupoMuscular;
    private String nivelDificultad;
    private Character genero;
    private Double met;

    @ManyToMany(mappedBy = "Entrenamiento") // Relación bidireccional
    private Set<Usuario> usuario = new HashSet<>();

    @ManyToMany(mappedBy = "Entrenamiento") // Relación bidireccional
    private Set<Rutina_Entrenamiento> rutina_Entrenamientos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idTipoEntrenamiento")
    private Tipo_de_Entrenamiento tipo_de_Entrenamiento;

    @ManyToMany
    @JoinTable(
    name = "registro_sugerencia", // Nombre de la tabla de unión
    joinColumns = @JoinColumn(name = "idEntrenamiento"), // Columna que hace referencia a Entrenamiento
    inverseJoinColumns = @JoinColumn(name = "idSugerencia") // Columna que hace referencia a Sugerencia
    )
    private Set<Sugerencia> sugerencias = new HashSet<>();

}
