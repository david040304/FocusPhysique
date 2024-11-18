package com.springboot.focusphysique.backend.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        @DeleteMapping("/eliminarUsuario")
    public ResponseEntity<String> eliminarUsuario(@RequestBody Map<String, Integer> datos) {
        try {
            // Validación de que el ID de usuario no sea nulo
            Integer Id_usuario = datos.get("Id_usuario");
            if (Id_usuario == null) {
                return ResponseEntity.badRequest().body("El ID de usuario es obligatorio.");
            }

            // Llamada al servicio para eliminar el usuario
            usuarioService.eliminarUsuario(Id_usuario);
            return ResponseEntity.ok("Usuario eliminado con éxito.");
        } catch (Exception e) {
            // Manejo de errores generales
            return ResponseEntity.status(500).body("Error al eliminar el usuario: " + e.getMessage());
        }
    }
    
    //llamada al método actualizar usuario
    @PutMapping("/actualizarUsuario")
    public ResponseEntity<String> actualizarUsuario(@RequestBody Map<String, Object> datos) {
        try {
            // Valida si el id existe
            
            String id_Usuario = datos.get("Id_usuario").toString();
            String p_Nombre = (String) datos.get("P_Nombre");
            String s_Nombre = (String) datos.get("S_Nombre");
            String p_Apellido = (String) datos.get("P_Apellido");
            String s_Apellido = (String) datos.get("S_Apellido");
            Integer edad = Integer.parseInt(datos.get("Edad").toString());
            String telefono = (String) datos.get("Telefono");
            Character genero = datos.get("Genero").toString().charAt(0);
            Double altura_Inicio = Double.parseDouble(datos.get("Altura_Inicio").toString());
            Double peso_Inicio = Double.parseDouble(datos.get("Peso_Inicio").toString());
            Integer id_Cuenta = Integer.parseInt(datos.get("Id_cuenta").toString());

            usuarioService.actualizarUsuario(id_Usuario, p_Nombre, s_Nombre, p_Apellido, s_Apellido,
            edad, telefono, genero, altura_Inicio, peso_Inicio, id_Cuenta);
            return ResponseEntity.ok("Usuario actualizado con éxito.");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Error en el formato de los datos numéricos.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el usuario: " + e.getMessage());
        }
    }
}

