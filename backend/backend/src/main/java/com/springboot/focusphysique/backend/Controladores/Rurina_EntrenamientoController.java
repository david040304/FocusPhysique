package com.springboot.focusphysique.backend.Controladores;
import java.sql.Time;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Servicios.Rutina_EntrenamientoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Rutina_Entrenamiento")
public class Rurina_EntrenamientoController {
    @Autowired
    private Rutina_EntrenamientoService rutina_EntrenamientoService;

    @PostMapping("/InsertRutina")
    public ResponseEntity<String> Insert_Rutina_Entrenamiento(@RequestBody Map<String, Object> datos) {
        try {
            if (datos.get("nombre" ) == null || datos.get("descripcion") == null || datos.get("duracion") == null ||
                datos.get("nivel_dificultad") == null) {
                return ResponseEntity.status(400).body("Error: Todos los campos son requeridos.");
            }

            // Convertir el valor de "duracion" a Time
        String duracionStr = datos.get("duracion").toString();
        Time duracion;
        try {
            duracion = Time.valueOf(duracionStr); // Formato esperado: HH:mm:ss
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body("Error: La duración debe tener el formato HH:mm:ss.");
        }
        // Llamar al servicio para insertar la rutina
        rutina_EntrenamientoService.Insert_Rutina_Entrenamiento(
            datos.get("nombre").toString(),
            datos.get("descripcion").toString(),
            duracion,
            datos.get("nivel_dificultad").toString()
        );
        return ResponseEntity.ok("Rutina de entrenamiento insertada con éxito.");

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al insertar la rutina: " + e.getMessage());
        }
    }

    // Eliminar una rutina de entrenamiento
    @DeleteMapping("/eliminarRutina")
    public ResponseEntity<String> eliminarRutina(@RequestBody Map<String, Integer> datos) {
        try {
            // Validación de que el ID de la rutina no sea nulo
            Integer id_Rutina = datos.get("Id_Rutina");
            if (id_Rutina == null) {
                return ResponseEntity.badRequest().body("El ID de la rutina es obligatorio.");
            }

            // Llamada al servicio para eliminar la rutina
            rutina_EntrenamientoService.eliminar_Rutina_Entrenamiento(id_Rutina);
            return ResponseEntity.ok("Rutina eliminada con éxito.");
        } catch (Exception e) {
            // Manejo de errores generales
            return ResponseEntity.status(500).body("Error al eliminar la rutina: " + e.getMessage());
        }
    }

    // Actualizar una rutina de entrenamiento
    @PutMapping("/actualizarRutina")
    public ResponseEntity<String> actualizarRutina(@RequestBody Map<String, Object> datos) {
        try {
            // Extracción y validación de datos
            Integer id_Rutina = (Integer) datos.get("id_Rutina");
            String nombre = (String) datos.get("nombre");
            String descripcion = (String) datos.get("descripcion");
            String duracionStr = (String) datos.get("duracion");
            String nivel_Dificultad = (String) datos.get("nivel_Dificultad");

            // Conversión de duración al tipo Time
            Time duracion;
            try {
                duracion = Time.valueOf(duracionStr); // Formato esperado: HH:mm:ss
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body("La duración debe tener el formato HH:mm:ss.");
            }

            // Llamada al servicio para actualizar la rutina
            rutina_EntrenamientoService.Update_Rutina_Entrenamiento(
                id_Rutina,nombre,descripcion, duracion,nivel_Dificultad
            );
            return ResponseEntity.ok("Rutina actualizada con éxito.");
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Error en el formato de los datos numéricos.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar la rutina: " + e.getMessage());
        }
    }
}
