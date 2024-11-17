package com.springboot.focusphysique.backend.Entidades;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cuenta;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String contraseña;

}
