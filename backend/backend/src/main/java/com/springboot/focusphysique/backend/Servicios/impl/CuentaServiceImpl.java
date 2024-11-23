package com.springboot.focusphysique.backend.Servicios.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Repositorio.RepositoryCuenta;
import com.springboot.focusphysique.backend.Servicios.ICuentaService;

@Service
public class CuentaServiceImpl implements ICuentaService{
    // Implementacion de los metodos de ICuentaService
    @Autowired
    private RepositoryCuenta repo;

    // Implementacion del metodo crearCuenta
    @Override
    public Cuenta crearCuenta(Cuenta datosCuenta) {
        return repo.save(datosCuenta);
    }

    //mostar todas las cuentas
    @Override
    public Iterable<Cuenta> ListarCuentas() {
        return repo.findAll();
    }
    
    // Implementacion del metodo para buscar por id
    public Optional<Cuenta> BuscarCuentaId(Integer id) {
        return repo.findById(id);
    }
    
    
    // Implementacion del metodo para Eliminarr cuenta
    @Override
    public Optional<Cuenta> EliminarCuenta (Integer id) {
        return repo.findById(id).map(Cuenta -> {
            repo.delete(Cuenta);
            return Cuenta;
        });
    }
    
    // Implementacion del metodo para actualizar cuenta
    @Override 
    public Cuenta ActualizarCuenta(Integer id, Cuenta datosCuenta){
        return repo.findById(id).map(Cuenta ->{
            Cuenta.setUsuario(datosCuenta.getUsuario());
            Cuenta.setContraseña(datosCuenta.getContraseña());
            return repo.save(Cuenta);
        }).orElseThrow(() -> new RuntimeException("Cuenta con ID " + id + " no encontrada"));
    }
    
    

}
