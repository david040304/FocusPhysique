package com.springboot.focusphysique.backend.Entidades;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Usuario extends Persona{

    private Character Genero;
    private Double Altura_Inicio;
    private Double Peso_Inicio;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cuenta cuenta;

    @ManyToMany
    @JoinTable(
        name = "registro_entrenamiento", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "Id"), // Columna de esta entidad
        inverseJoinColumns = @JoinColumn(name = "idEntrenamiento") // Columna de la otra entidad
    )
    private Set<Entrenamiento> Entrenamiento = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "regsitro_rutina", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "Id"), // Columna de esta entidad
        inverseJoinColumns = @JoinColumn(name = "id_Rutina") // Columna de la otra entidad
    )
    private Set<Rutina_Entrenamiento> Rutina_Entrenamiento = new HashSet<>();
}
