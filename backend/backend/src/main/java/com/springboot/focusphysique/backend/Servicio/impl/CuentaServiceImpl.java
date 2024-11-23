package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Repositorio.RepositoryCuenta;
import com.springboot.focusphysique.backend.Servicio.ICuentaServicio;

@Service
public class CuentaServiceImpl implements ICuentaServicio{
    @Autowired
    private RepositoryCuenta repo;

    @Override
    public Cuenta crearCuenta(Cuenta datosCuenta) {
        return repo.save(datosCuenta);        
    }

    @Override
    public Optional<Cuenta> obtenerCuentaPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Cuenta> obtenerCuentas() {
        return repo.findAll();    }

    @Override
    public Optional<Cuenta> eliminarCuenta(Integer id) {
        return repo.findById(id).map(cuenta -> {
            repo.delete(cuenta);
            return cuenta;
        });
    }

}
