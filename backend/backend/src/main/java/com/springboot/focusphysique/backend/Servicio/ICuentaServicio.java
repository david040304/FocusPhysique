package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;

import com.springboot.focusphysique.backend.Entidades.Cuenta;

public interface ICuentaServicio {
    Cuenta crearCuenta(Cuenta datosCuenta);
    Optional<Cuenta> obtenerCuentaPorId(Integer id);
    Iterable<Cuenta> obtenerCuentas();
    Optional<Cuenta> eliminarCuenta(Integer id);
}
