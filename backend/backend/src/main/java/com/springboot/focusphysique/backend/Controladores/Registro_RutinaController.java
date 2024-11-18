package com.springboot.focusphysique.backend.Controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.focusphysique.backend.Servicios.Regsitro_RutinaService;

public class Registro_RutinaController {
    @Autowired
    private Regsitro_RutinaService registroRutinaService;

    @PostMapping("/insertarRegistroRutina")
    public ResponseEntity<String> insertarRegistroRutina(@RequestBody Map<String, Object> datos) {
        try {
            // Validación de los campos necesarios
            if (datos.get("id_Usuario") == null || datos.get("id_Rutina") == null) {
                return ResponseEntity.status(400).body("Error: Todos los campos son requeridos.");
            }

            // Llamada al servicio para insertar el registro de rutina
            registroRutinaService.insertarRegistroRutina(
                Integer.parseInt(datos.get("id_Usuario").toString()),
                Integer.parseInt(datos.get("id_Rutina").toString())
            );
            return ResponseEntity.ok("Registro de rutina insertado con éxito.");
        } catch (NumberFormatException e) {
            // Si hay un error al parsear números, se captura aquí
            return ResponseEntity.status(400).body("Error: Formato de número incorrecto: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otro tipo de excepción y devuelve un mensaje genérico
            return ResponseEntity.status(500).body("Error al insertar el registro de rutina: " + e.getMessage());
        }
    }

    @DeleteMapping("/eliminarRegistroRutina")
    public ResponseEntity<String> eliminarRegistroRutina(@RequestBody Map<String, Integer> datos) {
        try {
            // Validación de que el ID del registro de rutina no sea nulo
            Integer id_Reg_Rutina = datos.get("Id_Reg_Rutina");
            if (id_Reg_Rutina == null) {
                return ResponseEntity.badRequest().body("El ID del registro de rutina es obligatorio.");
            }

            // Llamada al servicio para eliminar el registro de rutina
            registroRutinaService.eliminarRegistroRutina(id_Reg_Rutina);
            return ResponseEntity.ok("Registro de rutina eliminado con éxito.");
        } catch (Exception e) {
            // Manejo de errores generales
            return ResponseEntity.status(500).body("Error al eliminar el registro de rutina: " + e.getMessage());
        }
    }

    // Llamada al método actualizar registro de rutina
    @PutMapping("/actualizarRegistroRutina")
    public ResponseEntity<String> actualizarRegistroRutina(@RequestBody Map<String, Object> datos) {
        try {
            Integer idRegRutina = Integer.parseInt(datos.get("Id_Reg_Rutina").toString());
            Integer idUsuario = Integer.parseInt(datos.get("Id_Usuario").toString());
            Integer idRutina = Integer.parseInt(datos.get("Id_Rutina").toString());

            registroRutinaService.actualizarRegistroRutina(idRegRutina, idUsuario, idRutina);
            return ResponseEntity.ok("Registro de rutina actualizado con éxito.");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Error en el formato de los datos numéricos.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar el registro de rutina: " + e.getMessage());
        }
    }
}
