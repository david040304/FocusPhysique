package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Controladores.mapper.SugerenciaMapper;
import com.springboot.focusphysique.backend.Dto.SugerenciaDto;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Repositorio.RepositorySugerencia;
import com.springboot.focusphysique.backend.Servicio.ISugerenciaSercio;
import com.springboot.focusphysique.backend.exeption.ResourceNotFoundExceptio;

@Service
public class SugerenciaSreviceImpl implements ISugerenciaSercio {

    @Autowired
    private RepositorySugerencia repo;

    @Override
    public SugerenciaDto crearSugerencia(SugerenciaDto sugerenciaDto) {
        Sugerencia sugerencia = SugerenciaMapper.mapToSugerencia(sugerenciaDto);
        Sugerencia savedSugerencia = repo.save(sugerencia);
        return SugerenciaMapper.mapSugerenciaDto(savedSugerencia);
    }

    @Override
    public SugerenciaDto obtenerSugerenciaId(Integer idSugerencia) {
        Sugerencia sugerencia = repo.findById(idSugerencia)
            .orElseThrow(() -> new ResourceNotFoundExceptio("Sugerencia is not exisst with given id: " + idSugerencia));
        return SugerenciaMapper.mapSugerenciaDto(sugerencia);
    }

    @Override
    public List<SugerenciaDto> getAllSugerencias() {
        List<Sugerencia> sugerencias = repo.findAll();
        return sugerencias.stream().map((sugerencia) -> SugerenciaMapper.mapSugerenciaDto(sugerencia))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<Sugerencia> eliminarSugerencia(Integer id) {
        return repo.findById(id).map(sugerencia -> {
            repo.delete(sugerencia);
            return sugerencia;
        });
    }

}
