package com.springboot.focusphysique.backend.mapper;

import com.springboot.focusphysique.backend.Dto.EntrenamientoDto;
import com.springboot.focusphysique.backend.Entidades.Entrenamiento;

public class EntrenamientoMapper {
    public static EntrenamientoDto mapEntrenamientoDto(Entrenamiento entrenamiento) {
        return new EntrenamientoDto(
            entrenamiento.getIdEntrenamiento(),
            entrenamiento.getNombreEntrenamiento(),
            entrenamiento.getDescripcionEntrenamiento(),
            entrenamiento.getGrupoMuscular(),
            entrenamiento.getNivelDificultad(),
            entrenamiento.getGenero(),
            entrenamiento.getDuracion(),
            entrenamiento.getMet()
        );
    }
}
