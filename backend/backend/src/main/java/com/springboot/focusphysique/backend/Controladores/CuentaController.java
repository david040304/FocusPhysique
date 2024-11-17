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
    
    //LLAMADA del procedimeinto eliminar 
    @PostMapping("/eliminarCuenta")
    public ResponseEntity<String> eliminarCuenta(@RequestBody Map<String, Integer> datos) {
        try {
        // Validar que el ID de la cuenta no sea nulo
            Integer id_cuenta = datos.get("id_cuenta");
            if (id_cuenta == null) {
                return ResponseEntity.badRequest().body("El ID de la cuenta es obligatorio.");
        }

        // Llamada al servicio para eliminar la cuenta
        cuentaService.eliminarCuenta(id_cuenta);
            return ResponseEntity.ok("Cuenta eliminada con éxito.");
        } catch (IllegalArgumentException e) {
            // Manejo de errores específicos de lógica de negocio
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        } catch (Exception e) {
            // Manejo de errores generales
            return ResponseEntity.status(500).body("Error al eliminar la cuenta: " + e.getMessage());
        }
    }

    //llamda al metodo actualizar cuenta
    @PostMapping("/actualizarCuenta")
    public ResponseEntity<String> actualizarCuenta(@RequestBody Map<String, String> datos) {
        try {
            // Parseo de los datos enviados en la solicitud
            Integer id_cuenta = Integer.parseInt(datos.get("id_cuenta")); // Convertir a Integer
            String usuario = datos.get("usuario");
            String contraseña = datos.get("contraseña");
            // Llamada al servicio para actualizar la cuenta
            cuentaService.actualizarCuenta(id_cuenta, usuario, contraseña);
            return ResponseEntity.ok("Cuenta actualizada con éxito.");
        } catch (NumberFormatException e) {
            // Manejo de errores de conversión
            return ResponseEntity.badRequest().body("El ID de cuenta debe ser un número válido.");
        } catch (Exception e) {
            // Manejo de otros errores
            return ResponseEntity.status(500).body("Error al actualizar la cuenta: " + e.getMessage());
        }
    }
    

}
