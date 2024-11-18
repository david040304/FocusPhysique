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
@Table(name = "Registro_Rutina_Entrenamiento")
@NamedStoredProcedureQuery(
    name = "Insert_Registro_Rutina_Entrenamiento",
    procedureName = "Insert_Registro_Rutina_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Reg_Runtina_Ent", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_entrenamiento", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_rutina", type = Integer.class)
    }
)
// Configuración del procedimiento para eliminar un registro
@NamedStoredProcedureQuery(
    name = "Delete_Registro_Rutina_Entrenamiento",
    procedureName = "Delete_Registro_Rutina_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Reg_Runtina_Ent", type = Integer.class)
    }
)
// Configuración del procedimiento para actualizar un registro
@NamedStoredProcedureQuery(
    name = "Update_Registro_Rutina_Entrenamiento",
    procedureName = "Update_Registro_Rutina_Entrenamiento",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Reg_Runtina_Ent", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_entrenamiento", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_rutina", type = Integer.class)
    }
)
public class Registro_Rutina_Entrenamiento {
    @Id
    @Column(name = "Id_Reg_Runtina_Ent")
    private Integer idRegRutinaEntren;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento", referencedColumnName = "Id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "Id_Rutina", referencedColumnName = "Id_rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}
