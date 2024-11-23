package com.springboot.focusphysique.backend.Entidades;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

 @ManyToOne
    @JoinColumn(name = "id_Usuario")
    @JsonBackReference  // Evitar la serialización infinita
    private Usuario id_Usuario;
}

