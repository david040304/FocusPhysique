package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Repositorio.RepositoryRutina_Entrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositorySugerencia;
import com.springboot.focusphysique.backend.Servicio.IRutinaEntrenamientoServicio;

@Service
public class Rutina_EntrenamientoServiceImpl implements IRutinaEntrenamientoServicio{
    @Autowired
    private RepositoryRutina_Entrenamiento repo;
    
    @Autowired
    private RepositorySugerencia reposSugerencia;

    @Override
    public Rutina_Entrenamiento crearRutinaEntrenamiento(Rutina_Entrenamiento datosRutina) {
        return repo.save(datosRutina);        
    }

    @Override
    public Optional<Rutina_Entrenamiento> obtenerRutinaPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Rutina_Entrenamiento> obtenerRutinas() {
        return repo.findAll();  
    }

    @Override
    public Optional<Rutina_Entrenamiento> eliminarRutina(Integer id) {
        return repo.findById(id).map(Rutina_Entrenamiento -> {
            repo.delete(Rutina_Entrenamiento);
            return Rutina_Entrenamiento;
        });
    }

    @Override
    public Set<Sugerencia> obtenerSugerenciasPorRutinaId(Integer idRutina) {
        return repo.findSugerenciasByRutinaId(idRutina);
    }

    @Override
    public Rutina_Entrenamiento agregarSugerencia(Integer idRutina, Integer idSugerencia) {
        Optional<Rutina_Entrenamiento> rutina = repo.findById(idRutina);
        Optional<Sugerencia> sugerencia = reposSugerencia.findById(idSugerencia);
        if (!rutina.isPresent() || !sugerencia.isPresent()) {
            return null; // Retornar null si no existe la rutina o la sugerencia
        }
        rutina.get().getSugerencias().add(sugerencia.get());
        return repo.save(rutina.get()); // Guardar la rutina actualizada
    }

    @Override
    public void eliminarSugerenciaPorRutinaId(Integer idRutina, Integer idSugerencia) {
        repo.deleteSugerenciaByRutinaId(idRutina, idSugerencia);
    }
}
