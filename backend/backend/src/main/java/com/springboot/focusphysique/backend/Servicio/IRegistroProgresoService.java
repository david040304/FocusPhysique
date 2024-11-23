package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import com.springboot.focusphysique.backend.Entidades.Registro_progreso;

public interface IRegistroProgresoService {
    Registro_progreso crearRegistro_progreso(Registro_progreso datosProgreso);
    Optional<Registro_progreso> obtenerRegsitro_progresoPorId(Integer id);
    Iterable<Registro_progreso> obtenerRegistro_progresos();
    Optional<Registro_progreso> eliminarRegistro_progreso(Integer id);
}
