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
@Table(name = "Tipo_de_Entrenamiento")
public class Tipo_de_Entrenamiento {
    @Id
    @Column(name = "Id_Tipo_Entren")
    private Integer idTipoEntren;

    @Column(name = "Nombre_tipo")
    private String nombreTipo;

    @Column(name = "Descripcion")
    private String descripcion;
}
