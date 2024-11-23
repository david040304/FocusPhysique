package com.springboot.focusphysique.backend.Entidades;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data

public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    private String usuario;
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Tipo_Cuenta tipocuenta;

}

