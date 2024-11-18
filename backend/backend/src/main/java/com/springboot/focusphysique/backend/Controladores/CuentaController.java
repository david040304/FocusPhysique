package com.springboot.focusphysique.backend.Controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Servicios.CuentaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Cuenta")

public class CuentaController {

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
    @DeleteMapping("/eliminarCuenta")
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
    @PutMapping("/actualizarCuenta")
    public ResponseEntity<String> actualizarCuenta(@RequestBody Map<String, String> datos) {
        try {
            // Obtener y validar datos
            Integer id_cuenta = Integer.parseInt(datos.get("id_cuenta"));
            String usuario = datos.get("usuario");
            String contraseña = datos.get("contraseña");

            // Llamar al servicio para actualizar la cuenta
            cuentaService.actualizarCuenta(id_cuenta, usuario, contraseña);

            return new ResponseEntity<>("Cuenta actualizada con éxito.", HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Error en el formato numérico: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al actualizar la cuenta: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    

}
