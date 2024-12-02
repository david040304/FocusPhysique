package com.springboot.focusphysique.backend.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulos_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArticulo;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "id")
    private Administrador administrador;
    
}
