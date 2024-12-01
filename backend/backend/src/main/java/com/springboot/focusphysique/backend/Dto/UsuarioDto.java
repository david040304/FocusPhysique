package com.springboot.focusphysique.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Integer id;
    private String P_Nombre;
    private String S_Nombre;
    private String P_Apellido;
    private String S_Apellido;
    private Integer Edad;
    private String Telefono;
    private Character Genero;
    private Double Altura_Inicio;
    private Double Peso_Inicio;
}
