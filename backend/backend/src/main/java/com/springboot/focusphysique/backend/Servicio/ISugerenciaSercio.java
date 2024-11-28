package com.springboot.focusphysique.backend.Servicio;

import java.util.List;

import com.springboot.focusphysique.backend.Dto.SugerenciaDto;

public interface ISugerenciaSercio {
    SugerenciaDto crearSugerencia(SugerenciaDto sugerenciaDto);
    SugerenciaDto obtenerSugerenciaId(Integer idSugerencia);
    List<SugerenciaDto> getAllSugerencias();
    SugerenciaDto updateSugerencia(Integer idSugerencia, SugerenciaDto updateSugerencia);
    void  deleteSugerencia(Integer idSugerencia);
}
