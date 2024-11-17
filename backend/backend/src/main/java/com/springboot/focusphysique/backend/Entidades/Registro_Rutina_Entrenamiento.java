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
@Table(name = "Registro_Rutina_Entrenamiento")
public class Registro_Rutina_Entrenamiento {
    @Id
    @Column(name = "Id_Reg_Runtina_Ent")
    private Integer idRegRutinaEntren;

    @ManyToOne
    @JoinColumn(name = "Id_entrenamiento", referencedColumnName = "Id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "Id_rutina", referencedColumnName = "Id_rutina")
    private Rutina_Entrenamiento rutinaEntrenamiento;
}
