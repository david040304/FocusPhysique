package com.springboot.focusphysique.backend.Dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Articulo_InfoDto {
    private Integer idArticulo;
    private String titulo;
    private String contenido;
    private LocalDate fechaPublicacion;
}
