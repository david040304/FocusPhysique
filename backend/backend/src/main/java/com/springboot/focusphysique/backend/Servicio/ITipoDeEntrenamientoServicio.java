package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;

import com.springboot.focusphysique.backend.Entidades.Tipo_de_Entrenamiento;

public interface ITipoDeEntrenamientoServicio {
    Tipo_de_Entrenamiento crearTipo(Tipo_de_Entrenamiento datosTipo);
    Optional<Tipo_de_Entrenamiento> obtenerTipoPorId(Integer id);
    Iterable<Tipo_de_Entrenamiento> obtenerTipos();
    Optional<Tipo_de_Entrenamiento> eliminarTipo(Integer id);

}
