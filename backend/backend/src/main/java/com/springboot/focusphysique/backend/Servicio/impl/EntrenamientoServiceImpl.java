package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Servicio.IEntrenamientoServicio;

@Service
public class EntrenamientoServiceImpl implements IEntrenamientoServicio {
    @Autowired
    private RepositoryEntrenamiento repo;

    @Override
    public Entrenamiento crearEntrenamiento(Entrenamiento datosEntrenamiento){
        return repo.save(datosEntrenamiento);
    }

    @Override
    public Optional<Entrenamiento> obtenerEntrenPorId(Integer id){
        return repo.findById(id);
    }

    @Override
    public Iterable<Entrenamiento> obtenerEntren(){
        return repo.findAll();
    }

    @Override
    public Optional<Entrenamiento> eliminarEntren(Integer id){
        return repo.findById(id).map(entrenamiento -> {
            repo.delete(entrenamiento);
            return entrenamiento;
        });
    }
   



}
