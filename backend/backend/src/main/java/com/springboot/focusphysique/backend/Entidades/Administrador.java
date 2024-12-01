package com.springboot.focusphysique.backend.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrador extends Persona{

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Cuenta cuenta;
}
