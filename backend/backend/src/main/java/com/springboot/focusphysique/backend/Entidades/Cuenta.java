package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    private String usuario;
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Tipo_Cuenta tipocuenta;

}

