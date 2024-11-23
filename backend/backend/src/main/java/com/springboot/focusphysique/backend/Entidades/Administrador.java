package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Administrador extends Persona{

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cuenta cuenta;
}
