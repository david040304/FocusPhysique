package com.springboot.focusphysique.backend.Entidades;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Rutina_Entrenamiento {
    @Id
    private Integer id_Rutina;
    private String nombre;
    private String descripcion;
    private Time duracion;
    private String nivel_Dificultad;

    @OneToMany(mappedBy = "idRegRutina", cascade = CascadeType.ALL)
    private List<Registro_Rutina> registroRutina;

    @OneToMany(mappedBy = "idRegRutinaEntren", cascade = CascadeType.ALL)
    private List<Registro_Rutina_Entrenamiento> registroRutinaEntrenamiento;

    @OneToMany(mappedBy = "idSugerencia", cascade = CascadeType.ALL)
    private List<Sugerencia> sugerencia;

}
