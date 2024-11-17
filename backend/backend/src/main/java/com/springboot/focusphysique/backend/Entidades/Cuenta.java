package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "Cuenta")
// configuracion del procedimiento insert
@NamedStoredProcedureQuery(
    name = "Insert_Cuenta",
    procedureName = "Insert_Cuenta",
    parameters = {
        @StoredProcedureParameter(name = "p_usuario", type = String.class),
        @StoredProcedureParameter(name = "p_contraseña", type = String.class)
    }

)

public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_cuenta")
    private Integer Id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String contraseña;

}
