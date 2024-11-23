package com.springboot.focusphysique.backend.Entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Usuario;
    private String P_Nombre;
    private String S_Nombre;
    private String P_Apellido;
    private String S_Apellido;
    private Integer Edad;
    private String Telefono;
    private Character Genero;
    private Double Altura_Inicio;
    private Double Peso_Inicio;
    
@OneToMany(mappedBy = "idRegRutina", cascade = CascadeType.ALL)
    private List<Registro_Rutina> RegistroRutina;

    @OneToMany(mappedBy = "idRegRutinaEntren", cascade = CascadeType.ALL)
    private List<Registro_Rutina_Entrenamiento> regRutEnt;

    @OneToMany(mappedBy = "idRegProgreso", cascade = CascadeType.ALL)
    private List<Registro_progreso> registroProgreso;

    @OneToMany(mappedBy = "id_Usuario", cascade = CascadeType.ALL)
    @JsonManagedReference  // Controla la serialización de la lista de cuentas
    private List<Cuenta> cuentas;
}
