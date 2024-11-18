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
@Table(name = "Registro_Rutina")
// Procedimiento para insertar un registro
@NamedStoredProcedureQuery(
    name = "Insert_Registro_Rutina",
    procedureName = "Insert_Registro_Rutina",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Reg_Rutina", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_usuario", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_rutina", type = Integer.class)
    }
)
// Procedimiento para eliminar un registro
@NamedStoredProcedureQuery(
    name = "Delete_Registro_Rutina",
    procedureName = "Delete_Registro_Rutina",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Reg_Rutina", type = Integer.class)
    }
)
// Procedimiento para actualizar un registro
@NamedStoredProcedureQuery(
    name = "Update_Registro_Rutina",
    procedureName = "Update_Registro_Rutina",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_Reg_Rutina", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_usuario", type = Integer.class),
        @StoredProcedureParameter(name = "P_Id_rutina", type = Integer.class)
    }
)

public class Registro_Rutina {
    @Id
    @Column(name = "Id_Reg_Rutina")
    private Integer idRegRutina;

    @ManyToOne
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Id_rutina", referencedColumnName = "Id_rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}