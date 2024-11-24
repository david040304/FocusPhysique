package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositorySugerencia;
import com.springboot.focusphysique.backend.Servicio.IEntrenamientoServicio;

@Service
public class EntrenamientoServiceImpl implements IEntrenamientoServicio {
    @Autowired
    private RepositoryEntrenamiento repo;
    @Autowired
    private RepositorySugerencia reposSugerencia;

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

    @Override
    public Set<Sugerencia> getSugeSerenciasByEntrenamientoId(Integer idEntrenamiento) {
        return repo.findSugerenciasByEntrenamientoId(idEntrenamiento);
    }

    // Método para agregar una sugerencia a un entrenamiento
    @Override
    public Entrenamiento agregarSugerencia(Integer idEntrenamiento, Integer idSugerencia) {
        Optional<Entrenamiento> entrenamiento = repo.findById(idEntrenamiento);
        Optional<Sugerencia> sugerencia = reposSugerencia.findById(idSugerencia);
        if (!entrenamiento.isPresent() || !sugerencia.isPresent()) {
            return null; // Si no se encuentra el entrenamiento o la sugerencia, no se puede agregar
        }
        entrenamiento.get().getSugerencias().add(sugerencia.get()); // Añadir la sugerencia al entrenamiento
        return repo.save(entrenamiento.get()); // Guardar el entrenamiento actualizado
    }

}
