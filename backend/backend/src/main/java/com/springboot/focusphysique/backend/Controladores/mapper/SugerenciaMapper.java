package com.springboot.focusphysique.backend.Controladores.mapper;

import com.springboot.focusphysique.backend.Dto.SugerenciaDto;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;


public class SugerenciaMapper {
    public static SugerenciaDto mapSugerenciaDto(Sugerencia sugerencia){
        return new SugerenciaDto(
            sugerencia.getIdSugerencia(),
            sugerencia.getDescripcion(),
            sugerencia.getTiposugerencia()
        );
    }

    public static Sugerencia mapToSugerencia(SugerenciaDto sugerenciaDto){
        return new Sugerencia(
            sugerenciaDto.getIdSugerencia(),
            sugerenciaDto.getDescripcion(),
            sugerenciaDto.getTiposugerencia(), 
            null, 
            null
        );
    }
}
