package com.springboot.focusphysique.backend.Servicios;

import java.util.Optional;

import com.springboot.focusphysique.backend.Entidades.Cuenta;

public interface ICuentaService {
    //Crear Cuenta
    Cuenta crearCuenta(Cuenta datosCuenta);
    // Mostar todas las cuentas
    Iterable<Cuenta> ListarCuentas();
    // Buscar cuenta por id
    Optional<Cuenta> BuscarCuentaId(Integer id);
    // Elimanar cuenta
    Optional<Cuenta> EliminarCuenta(Integer id);
    // Actualizar cuenta
    Cuenta ActualizarCuenta(Integer id, Cuenta datosCuenta);


}
