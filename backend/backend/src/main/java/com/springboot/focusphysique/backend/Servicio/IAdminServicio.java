package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import com.springboot.focusphysique.backend.Entidades.Administrador;


public interface IAdminServicio {
    Administrador crearAdministrador(Administrador datosAdmin);
    Optional<Administrador> obtenerAdminPorId(Integer id);
    Iterable<Administrador> obtenerAdmin();
    Optional<Administrador> eliminarAdmin(Integer id);

}
