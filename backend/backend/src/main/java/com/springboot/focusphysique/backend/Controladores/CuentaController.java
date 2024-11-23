package com.springboot.focusphysique.backend.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Servicio.ICuentaServicio;

@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {
    @Autowired
    private ICuentaServicio cuentaServicio;

    @GetMapping
    public ResponseEntity<Iterable<Cuenta>> getAllCuentas() {
        return ResponseEntity.ok().body(cuentaServicio.obtenerCuentas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuenta> getCuentaPorId(@PathVariable Integer id) {
        Optional<Cuenta> opUsuario = cuentaServicio.obtenerCuentaPorId(id);
        if (opUsuario.isPresent()) {
            return ResponseEntity.ok().body(opUsuario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Cuenta crearCuenta(@RequestBody Cuenta entity) {
        return cuentaServicio.crearCuenta(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cuenta> eliminarCuenta(@PathVariable(name = "id") Integer id) {
        Optional<Cuenta> cuenta = cuentaServicio.eliminarCuenta(id);
        if (cuenta.isPresent()) {
            return ResponseEntity.ok().body(cuenta.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cuenta> actualizarCuenta(@PathVariable(name = "id") Integer id,
            @RequestBody Cuenta cuentaOld) {
                if (cuentaOld == null || cuentaOld.getUsuario() == null || cuentaOld.getContraseña() == null) {
                    return ResponseEntity.badRequest().body(null);
                }
                // Buscar la cuenta existente por ID
                Optional<Cuenta> cuentaOpt = cuentaServicio.obtenerCuentaPorId(id);
                if (cuentaOpt.isPresent()) {
                    Cuenta cuentaNew = cuentaOpt.get();
                    // Actualizar campos necesarios
                    cuentaNew.setUsuario(cuentaOld.getUsuario());
                    cuentaNew.setContraseña(cuentaOld.getContraseña());
                    // Guardar cambios
                    Cuenta cuentaActualizada = cuentaServicio.crearCuenta(cuentaNew);
                    return ResponseEntity.ok(cuentaActualizada);
                }
                // Si no encuentra la cuenta, retornar 404
                return ResponseEntity.notFound().build();
    }
}
