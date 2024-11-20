package com.springboot.focusphysique.backend.Entidades;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    private Integer Id_Usuario;
    private String P_Nombre;
    private String S_Nombre;
    private String P_Apellido;
    private String S_Apellido;
    private Integer Edad;
    private String Telefono;
    private Character Genero;
    private Double Altura_Inicio;
    private Double Peso_Inicio;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCuenta", referencedColumnName = "idCuenta")
    private Cuenta cuenta;

    @OneToMany(mappedBy = "idRegRutina", cascade = CascadeType.ALL)
    private List<Registro_Rutina> RegistroRutina;

    @OneToMany(mappedBy = "idRegEnt", cascade = CascadeType.ALL)
    private List<Registro_Rutina_Entrenamiento> regRutEnt;

    @OneToMany(mappedBy = "idRegProgreso", cascade = CascadeType.ALL)
    private List<Registro_progreso> registroProgreso;
}