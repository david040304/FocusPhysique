package com.springboot.focusphysique.backend.Dto;

import com.springboot.focusphysique.backend.Entidades.Tipo_Sugerencia;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SugerenciaDto {
    private Integer idSugerencia;
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Tipo_Sugerencia tiposugerencia;
}
