package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;

public interface IEntrenamientoServicio {
    
    Entrenamiento crearEntrenamiento(Entrenamiento datosEntrenamiento);
    Optional<Entrenamiento> obtenerEntrenPorId(Integer id);
    Iterable<Entrenamiento> obtenerEntren();
    Optional<Entrenamiento> eliminarEntren(Integer id);


}
