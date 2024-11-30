package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
    public SugerenciaDto updateSugerencia(Integer idSugerencia, SugerenciaDto updateSugerencia){
        Sugerencia sugerencia = repo.findById(idSugerencia).orElseThrow(
            () -> new ResourceNotFoundExceptio("Sugerencia is not exists with given id:" + idSugerencia)
        );
        sugerencia.setDescripcion(updateSugerencia.getDescripcion());
        sugerencia.setTipoSugerencia(updateSugerencia.getTipoSugerencia());
        Sugerencia updatedSugerenciaObj = repo.save(sugerencia);
        return SugerenciaMapper.mapSugerenciaDto(updatedSugerenciaObj);
    }

    @Override
    public void deleteSugerencia(Integer idSugerencia) {
        Sugerencia sugerencia = repo.findById(idSugerencia).orElseThrow(
        () -> new ResourceNotFoundExceptio("Sugerencia is not exists with given id: " + idSugerencia) 
        );
        repo.deleteById(idSugerencia);
    }

}
