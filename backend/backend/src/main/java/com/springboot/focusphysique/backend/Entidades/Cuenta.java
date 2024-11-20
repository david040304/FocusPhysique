package com.springboot.focusphysique.backend.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@JsonIgnoreProperties
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    private String usuario;
    private String contraseña;

    @OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
    private Usuario usuarioEntity; // Relación bidireccional con la entidad Usuario

}
