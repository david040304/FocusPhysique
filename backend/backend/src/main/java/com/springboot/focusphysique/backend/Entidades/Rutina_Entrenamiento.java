package com.springboot.focusphysique.backend.Entidades;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Rutina_Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRutina;
    private String nombre;
    private String descripcion;
    private Time duracion;
    private String nivel_Dificultad;

    @ManyToMany(mappedBy = "Rutina_Entrenamiento") // Relación bidireccional
    private Set<Usuario> usuario = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "regsitro_rutina_entrenamiento", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "Id"), // Columna de esta entidad
        inverseJoinColumns = @JoinColumn(name = "idEntrenamiento") // Columna de la otra entidad
    )
    private Set<Entrenamiento> Entrenamiento = new HashSet<>();

    @ManyToMany
    @JoinTable(
    name = "registro_Rutina_sugerencia", // Nombre de la tabla de unión
    joinColumns = @JoinColumn(name = "id_Rutina"), // Columna que hace referencia a Rutina Entrenamiento
    inverseJoinColumns = @JoinColumn(name = "id_Sugerencia") // Columna que hace referencia a Sugerencia
    )
    private Set<Sugerencia> sugerencias = new HashSet<>();
}
