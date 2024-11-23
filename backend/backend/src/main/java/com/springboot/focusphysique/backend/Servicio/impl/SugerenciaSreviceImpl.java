package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Repositorio.RepositorySugerencia;
import com.springboot.focusphysique.backend.Servicio.ISugerenciaSercio;

@Service
public class SugerenciaSreviceImpl implements ISugerenciaSercio {

    @Autowired
    private RepositorySugerencia repo;

    @Override
    public Sugerencia crearSugerencia(Sugerencia datosSugerencia) {
        return repo.save(datosSugerencia);
    }

    @Override
    public Optional<Sugerencia> obtenerSugerenciaId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Sugerencia> obtenerSugerencias() {
        return repo.findAll();
    }

    @Override
    public Optional<Sugerencia> eliminarSugerencia(Integer id) {
        return repo.findById(id).map(sugerencia -> {
            repo.delete(sugerencia);
            return sugerencia;
        });
    }

}
