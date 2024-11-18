package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Entrenamiento")
//configurar el procedimiento insert
@NamedStoredProcedureQuery(
        name = "Insert_Entrenamiento",
        procedureName = "Insert_Entrenamiento",
        parameters = {
            @StoredProcedureParameter(name = "P_Nombre_entrenamiento", type = String.class),
            @StoredProcedureParameter(name = "P_Descripcion_entre", type = String.class),
            @StoredProcedureParameter(name = "P_Grupo_Muscular", type = String.class),
            @StoredProcedureParameter(name = "P_Lv_dificultad", type = String.class),
            @StoredProcedureParameter(name = "P_Genero",type = Character.class),
            @StoredProcedureParameter(name = "P_MET", type = Double.class),
            @StoredProcedureParameter(name = "P_Id_Tipo_Entren", type = Integer.class)

        }
    )
//configuracion del procedimiento update 
@NamedStoredProcedureQuery(
    name = "Update_Entrenamiento",
    procedureName = "Update_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_entrenamiento", type = Integer.class),
        @StoredProcedureParameter(name = "P_Nombre_entrenamiento", type = String.class),
        @StoredProcedureParameter(name = "P_Descripcion_entre", type = String.class),
        @StoredProcedureParameter(name = "P_Grupo_Muscular", type = String.class),
        @StoredProcedureParameter(name = "P_Lv_dificultad", type = String.class),
        @StoredProcedureParameter(name = "P_Genero", type = Character.class),
        @StoredProcedureParameter(name = "P_MET", type = Double.class),
        @StoredProcedureParameter(name = "P_Id_Tipo_Entren", type = Integer.class)
    }
)

//configuracion del procedimiento delete

@NamedStoredProcedureQuery(
    name = "Delete_Entrenamiento",
    procedureName = "Delete_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_entrenamiento", type = Integer.class)
    }
)


public class Entrenamiento {
    @Id
    @Column(name = "Id_entrenamiento")
    private Integer idEntrenamiento;

    @Column(name = "Nombre_entrenamiento")
    private String nombreEntrenamiento;

    @Column(name = "Descripcion_entre")
    private String descripcionEntrenamiento;

    @Column(name = "Grupo_Muscular")
    private String grupoMuscular;

    @Column(name = "Lv_dificultad")
    private String nivelDificultad;

    @Column(name = "Genero")
    private Character genero;

    @Column(name = "MET")
    private Double met;

    @ManyToOne
    @JoinColumn(name = "Id_Tipo_Entren", referencedColumnName = "Id_Tipo_Entren")
    private Tipo_de_Entrenamiento tipoDeEntrenamiento;
}
