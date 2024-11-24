package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import java.util.Set;


import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;

public interface IEntrenamientoServicio {
    
    Entrenamiento crearEntrenamiento(Entrenamiento datosEntrenamiento);
    Optional<Entrenamiento> obtenerEntrenPorId(Integer id);
    Iterable<Entrenamiento> obtenerEntren();
    Optional<Entrenamiento> eliminarEntren(Integer id);
    Set<Sugerencia> getSugerenciasByEntrenamientoId(Integer idEntrenamiento);
    Entrenamiento agregarSugerencia(Integer idEntrenamiento, Integer idSugerencia);
}