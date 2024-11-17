package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class Usuario {
    @Id
    @Column(name = "Id_usuario")
    private Integer idUsuario;

    @Column(name = "P_Nombre")
    private String primerNombre;

    @Column(name = "S_Nombre")
    private String segundoNombre;

    @Column(name = "P_Apellido")
    private String primerApellido;

    @Column(name = "S_Apellido")
    private String segundoApellido;

    @Column(name = "Edad")
    private Integer edad;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Genero")
    private Character genero;

    @Column(name = "Altura_Inicio")
    private Double alturaInicio;

    @Column(name = "Peso_Inicio")
    private Double pesoInicio;

    @ManyToOne
    @JoinColumn(name = "Id_cuenta", referencedColumnName = "Id_cuenta")
    private Cuenta cuenta;
}
