package com.springboot.focusphysique.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoEntrenamientoDto {
    private Integer idTipoEntrenamiento;
    private String nombreTipo;
    private String descripcion;
}
