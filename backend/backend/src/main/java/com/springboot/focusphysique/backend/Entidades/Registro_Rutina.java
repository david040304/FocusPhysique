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
@Table(name = "Registro_Rutina")
public class Registro_Rutina {
    @Id
    @Column(name = "Id_Reg_Rutina")
    private Integer idRegRutina;

    @ManyToOne
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "Id_rutina", referencedColumnName = "Id_rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}