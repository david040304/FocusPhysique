package com.springboot.focusphysique.backend.Servicios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;

@Service
public class EntrenamientoService {

    @Autowired
    private RepositoryEntrenamiento repositoryEntrenamiento;
    //metodo insert
    public void insertarEntrenamiento(String nombreEntrenamiento, String descripcionEntrenamiento, String grupoMuscular,String nivelDificultad, Character genero, Double met, Integer idTipoEntrenamiento) {
        repositoryEntrenamiento.insertEntrenamiento(nombreEntrenamiento, descripcionEntrenamiento, grupoMuscular,nivelDificultad, genero, met, idTipoEntrenamiento);
    }
    //metodo update
    public void updateEntrenamiento(Integer idEntrenamiento, String nombreEntrenamiento, String descripcionEntrenamiento, String grupoMuscular, String nivelDificultad, Character genero, Double met, Integer idTipoEntrenamiento) {
        repositoryEntrenamiento.updateEntrenamiento(idEntrenamiento, nombreEntrenamiento, descripcionEntrenamiento, grupoMuscular, nivelDificultad, genero, met, idTipoEntrenamiento);
    }
    //metodo delete
    public void deleteEntrenamiento(Integer idEntrenamiento) {
        repositoryEntrenamiento.deleteEntrenamiento(idEntrenamiento);
    }



}
