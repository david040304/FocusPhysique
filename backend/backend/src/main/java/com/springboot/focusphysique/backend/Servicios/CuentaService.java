package com.springboot.focusphysique.backend.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Repositorio.RepositoryCuenta;

@Service
public class CuentaService {

    @Autowired
    private RepositoryCuenta repositoryCuenta;
    //INSERT
    public void insertarCuenta(String usuario, String contraseña){
        repositoryCuenta.insertCuenta(usuario, contraseña);
    }
    //DELETE
    public void eliminarCuenta(Integer id){
        repositoryCuenta.deleteCuenta(id);
    }
    //UPDATE
    public void actualizarCuenta(Integer id, String usuario, String contraseña){
        repositoryCuenta.updateCuenta(id, usuario, contraseña);
    }


}
