package com.springboot.focusphysique.backend.Servicio;

import java.util.List;
import java.util.Optional;

import com.springboot.focusphysique.backend.Dto.SugerenciaDto;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;

public interface ISugerenciaSercio {
    SugerenciaDto crearSugerencia(SugerenciaDto sugerenciaDto);
    SugerenciaDto obtenerSugerenciaId(Integer idSugerencia);
    List<SugerenciaDto> getAllSugerencias();
    SugerenciaDto updateSugerencia(Integer idSugerencia, SugerenciaDto updateSugerencia);
    Optional<Sugerencia> eliminarSugerencia(Integer id);
    

}
