package com.springboot.focusphysique.backend.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Servicios.UsuarioService;

import java.util.Map;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/insertarUsuario")
    public ResponseEntity<String> insertarUsuario(@RequestBody Map<String, Object> datos) {
        try {
            // Validación de los campos necesarios
            if (datos.get("P_Nombre") == null || datos.get("S_Nombre") == null || 
                datos.get("P_Apellido") == null || datos.get("S_Apellido") == null || 
                datos.get("Edad") == null || datos.get("Telefono") == null || 
                datos.get("Genero") == null || datos.get("Altura_Inicio") == null || 
                datos.get("Peso_Inicio") == null || datos.get("Id_cuenta") == null) {
                return ResponseEntity.status(400).body("Error: Todos los campos son requeridos.");
            }

            // Llamada al servicio para insertar el usuario
            usuarioService.insertarUsuario(
                datos.get("P_Nombre").toString(),
                datos.get("S_Nombre").toString(),
                datos.get("P_Apellido").toString(),
                datos.get("S_Apellido").toString(),
                Integer.parseInt(datos.get("Edad").toString()),
                datos.get("Telefono").toString(),
                datos.get("Genero").toString().charAt(0),  // Si el género es un solo carácter
                Double.parseDouble(datos.get("Altura_Inicio").toString()),
                Double.parseDouble(datos.get("Peso_Inicio").toString()),
                Integer.parseInt(datos.get("Id_cuenta").toString())
            );
            return ResponseEntity.ok("Usuario insertado con éxito.");
        } catch (NumberFormatException e) {
            // Si hay un error al parsear números, se captura aquí
            return ResponseEntity.status(400).body("Error: Formato de número incorrecto: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otro tipo de excepción y devuelve un mensaje genérico
            return ResponseEntity.status(500).body("Error al insertar el usuario: " + e.getMessage());
        }
    }
}

