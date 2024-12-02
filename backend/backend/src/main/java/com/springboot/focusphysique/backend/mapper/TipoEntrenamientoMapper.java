package com.springboot.focusphysique.backend.mapper;

import com.springboot.focusphysique.backend.Dto.TipoEntrenamientoDto;
import com.springboot.focusphysique.backend.Entidades.Tipo_de_Entrenamiento;

public class TipoEntrenamientoMapper {
    public static TipoEntrenamientoDto mapToTipoEntrenamientoDto(Tipo_de_Entrenamiento tipoEntrenamiento){
        return new TipoEntrenamientoDto(
            tipoEntrenamiento.getIdTipoEntrenamiento(),
            tipoEntrenamiento.getNombreTipo(),
            tipoEntrenamiento.getDescripcion()
        );
    }

    public static Tipo_de_Entrenamiento mapToTipoEntrenamiento(TipoEntrenamientoDto tipoEntrenamientoDto){
        return new Tipo_de_Entrenamiento(
            tipoEntrenamientoDto.getIdTipoEntrenamiento(),
            tipoEntrenamientoDto.getNombreTipo(),
            tipoEntrenamientoDto.getDescripcion()
        );
    }
}
