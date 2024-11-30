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
import com.springboot.focusphysique.backend.exeption.ResourceNotFoundExceptio;

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
    public void eliminarRutina(Integer idRutina) {
        Rutina_Entrenamiento rutina = repo.findById(idRutina).orElseThrow(
        () -> new ResourceNotFoundExceptio("Rutina is not exists with given id: " + idRutina) 
        );
        rutina.getUsuario().clear();
        rutina.getSugerencias();
        rutina.getEntrenamiento();
        repo.deleteById(idRutina);
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
