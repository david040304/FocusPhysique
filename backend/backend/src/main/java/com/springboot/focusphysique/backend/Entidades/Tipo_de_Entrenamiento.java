package com.springboot.focusphysique.backend.Entidades;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Tipo_de_Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoEntrenamiento;
    private String nombreTipo;
    private String descripcion;
}
