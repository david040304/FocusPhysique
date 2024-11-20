package com.springboot.focusphysique.backend.Entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Entrenamiento {
    @Id
    private Integer idEntrenamiento;
    private String nombreEntrenamiento;


    private String descripcionEntrenamiento;
    private String grupoMuscular;
    private String nivelDificultad;
    private Character genero;
    private Double met;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoEntren")
    private Tipo_de_Entrenamiento tipo_de_Entrenamiento;

    @OneToMany(mappedBy = "idRegEnt", cascade = CascadeType.ALL)
    private List<Registro_Entrenamiento> registroEntrenamientos;

    @OneToMany(mappedBy = "idSugerencia", cascade = CascadeType.ALL)
    private List<Sugerencia> sugerencia;
}
