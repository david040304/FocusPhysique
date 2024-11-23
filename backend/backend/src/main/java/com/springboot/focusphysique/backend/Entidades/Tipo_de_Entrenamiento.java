package com.springboot.focusphysique.backend.Entidades;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Tipo_de_Entrenamiento {
    @Id
    private Integer idTipoEntren;
    private String nombreTipo;
    private String descripcion;

    @OneToMany(mappedBy = "idEntrenamiento", cascade = CascadeType.ALL)
    private List<Entrenamiento> entrenamientos;
}
