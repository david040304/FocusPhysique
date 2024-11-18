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
@Table(name = "usuario")
@Getter
@Setter
// Configuración del procedimiento insert
@NamedStoredProcedureQuery(
    name = "Insert_Usuario",
    procedureName = "Insert_Usuario",
    parameters = {
        @StoredProcedureParameter(name = "P_P_Nombre", type = String.class),
        @StoredProcedureParameter(name = "P_S_Nombre", type = String.class),
        @StoredProcedureParameter(name = "P_P_Apellido", type = String.class),
        @StoredProcedureParameter(name = "P_S_Apellido", type = String.class),
        @StoredProcedureParameter(name = "P_Edad", type = Integer.class),
        @StoredProcedureParameter(name = "P_Telefono", type = String.class),
        @StoredProcedureParameter(name = "P_Genero", type = Character.class),
        @StoredProcedureParameter(name = "P_Altura_Inicio", type = Double.class),
        @StoredProcedureParameter(name = "P_Peso_Inicio", type = Double.class),
        @StoredProcedureParameter(name = "P_Id_cuenta", type = Integer.class)
    }
)
// Configuración del procedimiento eliminar cuenta
@NamedStoredProcedureQuery(
    name = "Delete_Usuario",
    procedureName = "Delete_Usuario",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_usuario", type = Integer.class)
    }
)
// Configuración del procedimiento actualizar cuenta
@NamedStoredProcedureQuery(
    name = "Update_Usuario",
    procedureName = "Update_Usuario",
    parameters = {
        @StoredProcedureParameter(name = "P_Id_usuario", type = String.class),
        @StoredProcedureParameter(name = "P_P_Nombre", type = String.class),
        @StoredProcedureParameter(name = "P_S_Nombre", type = String.class),
        @StoredProcedureParameter(name = "P_P_Apellido", type = String.class),
        @StoredProcedureParameter(name = "P_S_Apellido", type = String.class),
        @StoredProcedureParameter(name = "P_Edad", type = Integer.class),
        @StoredProcedureParameter(name = "P_Telefono", type = String.class),
        @StoredProcedureParameter(name = "P_Genero", type = Character.class),
        @StoredProcedureParameter(name = "P_Altura_Inicio", type = Double.class),
        @StoredProcedureParameter(name = "P_Peso_Inicio", type = Double.class),
        @StoredProcedureParameter(name = "P_Id_cuenta", type = Integer.class)
    }
)

public class Usuario {
    @Id
    @Column(name = "Id_usuario")
    private Integer Id_Usuario;

    @Column(name = "P_Nombre")
    private String P_Nombre;

    @Column(name = "S_Nombre")
    private String S_Nombre;

    @Column(name = "P_Apellido")
    private String P_Apellido;

    @Column(name = "S_Apellido")
    private String S_Apellido;

    @Column(name = "Edad")
    private Integer Edad;

    @Column(name = "Telefono")
    private String Telefono;

    @Column(name = "Genero")
    private Character Genero;

    @Column(name = "Altura_Inicio")
    private Double Altura_Inicio;

    @Column(name = "Peso_Inicio")
    private Double Peso_Inicio;

    @ManyToOne
    @JoinColumn(name = "Id_cuenta", referencedColumnName = "Id_cuenta")
    private Cuenta cuenta;
}