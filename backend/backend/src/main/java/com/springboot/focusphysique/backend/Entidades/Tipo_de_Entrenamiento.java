package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Tipo_de_Entrenamiento")

// Configuración del procedimiento insert
@NamedStoredProcedureQuery(
    name = "Insert_Tipo_de_Entrenamiento",
    procedureName = "Insert_Tipo_de_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Nombre_tipo", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "P_Descripcion", mode = ParameterMode.IN, type = String.class)
    }
)
//configuracion del procedimiento update
@NamedStoredProcedureQuery(
    name = "Update_Tipo_de_Entrenamiento",
    procedureName = "Update_Tipo_de_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Tipo_Entren", mode = ParameterMode.IN, type = Integer.class),
        @StoredProcedureParameter(name = "P_Nombre_tipo", mode = ParameterMode.IN, type = String.class),
        @StoredProcedureParameter(name = "P_Descripcion", mode = ParameterMode.IN, type = String.class)
    }
)
// configuracion del procediento delete
@NamedStoredProcedureQuery(
    name = "Delete_Tipo_de_Entrenamiento",
    procedureName = "Delete_Tipo_de_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Tipo_Entren", mode = ParameterMode.IN, type = Integer.class)
    }
)

public class Tipo_de_Entrenamiento {
    @Id
    @Column(name = "Id_Tipo_Entren")
    private Integer idTipoEntren;

    @Column(name = "Nombre_tipo")
    private String nombreTipo;

    @Column(name = "Descripcion")
    private String descripcion;
}
