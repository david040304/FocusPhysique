package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;

public interface ISugerenciaSercio {
    Sugerencia crearSugerencia(Sugerencia datosSugerencia);
    Optional<Sugerencia> obtenerSugerenciaId(Integer id);
    Iterable<Sugerencia> obtenerSugerencias();
    Optional<Sugerencia> eliminarSugerencia(Integer id);
    

}
