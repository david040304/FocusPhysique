package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryRutina_Entrenamiento;
import com.springboot.focusphysique.backend.Servicio.IRutinaEntrenamientoServicio;

@Service
public class Rutina_EntrenamientoServiceImpl implements IRutinaEntrenamientoServicio{
    @Autowired
    private RepositoryRutina_Entrenamiento repo;

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
}
