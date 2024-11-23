package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;

public interface IRutinaEntrenamientoServicio {
    Rutina_Entrenamiento crearRutinaEntrenamiento(Rutina_Entrenamiento datosRutina);
    Optional<Rutina_Entrenamiento> obtenerRutinaPorId(Integer id);
    Iterable<Rutina_Entrenamiento> obtenerRutinas();
    Optional<Rutina_Entrenamiento> eliminarRutina(Integer id);
}
