package com.springboot.focusphysique.backend.Servicio;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;

public interface IEntrenamientoServicio {
    
    Entrenamiento crearEntrenamiento(Entrenamiento datosEntrenamiento);
    Optional<Entrenamiento> obtenerEntrenPorId(Integer id);
    Iterable<Entrenamiento> obtenerEntren();
    Optional<Entrenamiento> eliminarEntren(Integer id);
    Set<Sugerencia> getSugeSerenciasByEntrenamientoId(Integer idEntrenamiento);
    Entrenamiento agregarSugerencia(Integer idEntrenamiento, Integer idSugerencia);
    List<Entrenamiento> findByGenero(Character genero);
    List<Entrenamiento> findByNivelDificultad(String nivelDificultad);
    List<Entrenamiento> findByGrupoMuscular(String grupoMuscular);
    List<Entrenamiento> findByTipoDeEntrenamientoNombre(@Param("nombreTipo") String nombreTipo);
    void eliminarSugerenciaPorEntrenamientoId(Integer idEntrenamiento, Integer idSugerencia);


}