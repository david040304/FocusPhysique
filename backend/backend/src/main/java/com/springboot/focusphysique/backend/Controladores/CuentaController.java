package com.springboot.focusphysique.backend.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Repositorio.RepositoryCuenta;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class CuentaController {

    @Autowired
    private RepositoryCuenta RepositoryCuenta;

    //Listar todos las cuentas
    @GetMapping

    public List<Cuenta> buscar_Id_cuenta(@RequestParam Integer id_cuenta) {
        return RepositoryCuenta.findAllById(id_cuenta);
    }

    public List<Cuenta> listar () {
        return RepositoryCuenta.findAll();
    }

    //agregar nueva cuenta
    @PostMapping
    public Cuenta agregar(@RequestBody Cuenta cuenta ) {
        return RepositoryCuenta.save(cuenta);
    }
    



}
