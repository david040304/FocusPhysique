package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Tipo_de_Entrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryTipoDeEntrenamiento;
import com.springboot.focusphysique.backend.Servicio.ITipoDeEntrenamientoServicio;

@Service
public class TipoDeentrenamientoSreviceImpl implements ITipoDeEntrenamientoServicio{
    @Autowired
    private RepositoryTipoDeEntrenamiento  repo;
    
    @Override
    public Tipo_de_Entrenamiento crearTipo(Tipo_de_Entrenamiento datosTipo ){
        return repo.save(datosTipo);
    }

    @Override
    public Optional<Tipo_de_Entrenamiento> obtenerTipoPorId(Integer id){
        return repo.findById(id);
    }

    @Override
    public Iterable<Tipo_de_Entrenamiento> obtenerTipos(){
        return repo.findAll();
    }

    @Override
    public Optional<Tipo_de_Entrenamiento> eliminarTipo(Integer id){
        return repo.findById(id).map(Tipo_de_Entrenamiento ->{
            repo.delete(Tipo_de_Entrenamiento);
            return Tipo_de_Entrenamiento;
        });
    }



}
