package com.springboot.focusphysique.backend.Entidades;

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
    @Column(name = "Id_cuenta")
    private Integer Id;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String contraseña;

}
