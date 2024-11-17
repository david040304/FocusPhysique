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
@Getter
@Setter
@Table(name = "Registro_Entrenamiento")
public class Registro_Entrenamiento {
    @Id
    @Column(name = "Id_Reg_Ent")
    private Integer idRegEnt;

    @ManyToOne
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento", referencedColumnName = "Id_entrenamiento")
    private Entrenamiento entrenamiento;
}
