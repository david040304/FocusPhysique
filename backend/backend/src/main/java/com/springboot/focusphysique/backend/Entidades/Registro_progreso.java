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
@Table(name = "Registro_Progreso")
public class Registro_progreso {
    @Id
    @Column(name = "Id_Reg_progreso")
    private Integer idRegProgreso;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "Peso_max_levantado")
    private Integer pesoMaxLevantado;

    @Column(name = "Altura_Actual")
    private Double alturaActual;

    @Column(name = "Peso_Actual")
    private Double pesoActual;

    @ManyToOne
    @JoinColumn(name = "Id_usuario", referencedColumnName = "Id_usuario")
    private Usuario usuario;
}
