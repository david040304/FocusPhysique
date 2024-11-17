package com.springboot.focusphysique.backend.Controladores;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Repositorio.RepositoryCuenta;
import com.springboot.focusphysique.backend.Servicios.CuentaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Cuenta")

public class CuentaController {

    @Autowired
    private RepositoryCuenta RepositoryCuenta;
    @Autowired
    private CuentaService cuentaService;

    //lamada del procedimeinto para insert
    @PostMapping("/insertarCuenta")
    public ResponseEntity<String> insertarCuenta(@RequestBody Map<String, String> datos) {
        String usuario = datos.get("usuario");
        String contraseña = datos.get("contraseña");
        try {
            cuentaService.insertarCuenta(usuario, contraseña);
            return ResponseEntity.ok("Cuenta insertada con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al insertar la cuenta: " + e.getMessage());
        }
    }
    
    

    //Listar todos las cuentas
   // @GetMapping

   /*  public List<Cuenta> buscar_Id_cuenta(@RequestParam Integer Id) {
        return RepositoryCuenta.findAllById(Id);
    }

    public List<Cuenta> listar () {
        return RepositoryCuenta.findAll();
    }

    //agregar nueva cuenta
    @PostMapping
    public Cuenta agregar(@RequestBody Cuenta cuenta ) {
        return RepositoryCuenta.save(cuenta);
    }  */



}
