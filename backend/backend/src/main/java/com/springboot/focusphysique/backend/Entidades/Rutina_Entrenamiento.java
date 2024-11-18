package com.springboot.focusphysique.backend.Entidades;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Rutina_Entrenamiento")

// Configuración del procedimiento insert
@NamedStoredProcedureQuery(
    name = "Insert_Rutina_Entrenamiento",
    procedureName = "Insert_Rutina_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Nombre", type = String.class),
        @StoredProcedureParameter(name = "P_Descripcion", type = String.class),
        @StoredProcedureParameter(name = "P_Duracion", type = Time.class),
        @StoredProcedureParameter(name = "P_Lv_dificultad", type = String.class)
    }
)
// Configuración del procedimiento eliminar cuenta
@NamedStoredProcedureQuery(
    name = "Delete_Rutina_Entrenamiento",
    procedureName = "Delete_Rutina_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_rutina", type = Integer.class)
    }
)
// Configuración del procedimiento actualizar cuenta
@NamedStoredProcedureQuery(
    name = "Update_Rutina_Entrenamiento",
    procedureName = "Update_Rutina_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_rutina", type = Integer.class),
        @StoredProcedureParameter(name = "P_Nombre", type = String.class),
        @StoredProcedureParameter(name = "P_Descripcion", type = String.class),
        @StoredProcedureParameter(name = "P_Duracion", type = Time.class),
        @StoredProcedureParameter(name = "P_Lv_dificultad", type = String.class),
    }
)
public class Rutina_Entrenamiento {
    @Id
    @Column(name = "Id_rutina")
    private Integer id_Rutina;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Duracion")
    private Time duracion;

    @Column(name = "Lv_dificultad")
    private String nivel_Dificultad;
}
