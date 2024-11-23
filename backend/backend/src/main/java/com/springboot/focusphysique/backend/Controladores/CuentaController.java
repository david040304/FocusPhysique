package com.springboot.focusphysique.backend.Controladores;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Servicios.ICuentaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/Cuentas")

public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    // Crear una nueva cuenta
    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta entity) {
        return cuentaService.crearCuenta(entity);
    }

    //Mostrar todas las cuentas
    @GetMapping
    public ResponseEntity<Iterable<Cuenta>> obtenerCuentas(){
       return ResponseEntity.ok(cuentaService.ListarCuentas());
    }
    
    //Buscar cuenta por ID

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> obtenerCuentaPorId(@PathVariable Integer id) {
        Optional<Cuenta> cuenta = cuentaService.BuscarCuentaId(id);
        if(cuenta.isPresent()) {
            return ResponseEntity.ok().body(cuenta.get());
        }
       
        return cuenta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar Cuenta
    @DeleteMapping("/{id}")
    public ResponseEntity<Cuenta> eliminarCuenta(@PathVariable(name = "id") Integer id) {
        Optional<Cuenta> cuenta = cuentaService.EliminarCuenta(id);
        if(cuenta.isPresent()){
            return ResponseEntity.ok(cuenta.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    // Actualizar Cuenta
    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> ActualizarCuenta(@PathVariable Integer id,@RequestBody Cuenta datosCuenta){

        try{
            Cuenta cuentaActualizad = cuentaService.ActualizarCuenta(id,datosCuenta);
            return ResponseEntity.ok(cuentaActualizad);
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    
    
    

}
