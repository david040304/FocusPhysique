package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositorySugerencia;
import com.springboot.focusphysique.backend.Servicio.IEntrenamientoServicio;
import com.springboot.focusphysique.backend.exeption.ResourceNotFoundExceptio;


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
    public void eliminarEntren(Integer idEntrenamiento) {
        repo.findById(idEntrenamiento).orElseThrow(
        () -> new ResourceNotFoundExceptio("Entrenamiento is not exists with given id: " + idEntrenamiento) 
        );
        repo.deleteById(idEntrenamiento);
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

    @Override
    public List<Entrenamiento> findByGenero(Character genero) {
        return repo.findByGenero(genero);
    }

    @Override
    public List<Entrenamiento> findByNivelDificultad(String nivelDificultad) {
        return repo.findByNivelDificultad(nivelDificultad);
    }
    @Override
    public List<Entrenamiento> findByGrupoMuscular(String grupoMuscular) {
        return repo.findByGrupoMuscular(grupoMuscular);
    }

    @Override
    public List<Entrenamiento> findByTipoDeEntrenamientoNombre(String nombreTipo) {
        return repo.findByTipoDeEntrenamientoNombre(nombreTipo);
    }

    @Override
    public void eliminarSugerenciaPorEntrenamientoId(Integer idEntrenamiento, Integer idSugerencia) {
        repo.deleteSugerenciaByEntrenamientoId(idEntrenamiento, idSugerencia);
    }
}
