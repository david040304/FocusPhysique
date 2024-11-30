package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import java.util.Set;

import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;

public interface IRutinaEntrenamientoServicio {
    Rutina_Entrenamiento crearRutinaEntrenamiento(Rutina_Entrenamiento datosRutina);
    Optional<Rutina_Entrenamiento> obtenerRutinaPorId(Integer id);
    Iterable<Rutina_Entrenamiento> obtenerRutinas();
    void eliminarRutina(Integer idRutina);
    Set<Sugerencia> obtenerSugerenciasPorRutinaId(Integer idRutina);
    Rutina_Entrenamiento agregarSugerencia(Integer idRutina, Integer idSugerencia);
    void eliminarSugerenciaPorRutinaId(Integer idRutina, Integer idSugerencia);

}
