package com.springboot.focusphysique.backend.Controladores;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Servicios.EntrenamientoService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/entrenamiento")
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    @PostMapping("/insertarEntrenamiento")
    public ResponseEntity<String> insertEntrenamiento(@RequestBody Map<String, String> datos) {
        try {
            // Obtener y validar datos de entrada
            String nombreEntrenamiento = datos.get("nombreEntrenamiento");
            String descripcionEntrenamiento = datos.get("descripcionEntrenamiento");
            String grupoMuscular = datos.get("grupoMuscular");
            String nivelDificultad = datos.get("nivelDificultad");
            Character genero = datos.get("genero").charAt(0); // Convierte String a Character
            Double met = Double.parseDouble(datos.get("met")); // Convierte String a Double
            Integer idTipoEntrenamiento = Integer.parseInt(datos.get("idTipoEntrenamiento")); // Convierte String a Integer

            // Llamar al servicio para insertar el entrenamiento
            entrenamientoService.insertarEntrenamiento(nombreEntrenamiento, descripcionEntrenamiento, grupoMuscular,
                    nivelDificultad, genero, met, idTipoEntrenamiento);

            return new ResponseEntity<>("Entrenamiento insertado con éxito.", HttpStatus.CREATED);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Error en el formato numérico: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Faltan datos obligatorios: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error interno: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // actualizar entrenamiento
    @PutMapping("/ActualizarEntrenamiento")
    public ResponseEntity<String> actualizarEntrenamiento(@RequestBody Map<String, String> datos) {
        try {
            // Obtener y validar datos de entrada
            Integer idEntrenamiento = Integer.parseInt(datos.get("idEntrenamiento"));
            String nombreEntrenamiento = datos.get("nombreEntrenamiento");
            String descripcionEntrenamiento = datos.get("descripcionEntrenamiento");
            String grupoMuscular = datos.get("grupoMuscular");
            String nivelDificultad = datos.get("nivelDificultad");
            Character genero = datos.get("genero").charAt(0); // Convierte String a Character
            Double met = Double.parseDouble(datos.get("met")); // Convierte String a Double
            Integer idTipoEntrenamiento = Integer.parseInt(datos.get("idTipoEntrenamiento")); // Convierte String a Integer

            // Llamar al servicio para actualizar el entrenamiento
            entrenamientoService.updateEntrenamiento(idEntrenamiento, nombreEntrenamiento, descripcionEntrenamiento, grupoMuscular,nivelDificultad, genero, met, idTipoEntrenamiento);

            return new ResponseEntity<>("Entrenamiento actualizado con éxito.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            // Capturamos excepciones por datos incorrectos
            return new ResponseEntity<>("Error de argumento: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // Capturamos cualquier otra excepción
            return new ResponseEntity<>("Error al actualizar el entrenamiento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        
    }
    
    // eliminar entrenamiento
    @DeleteMapping("/EliminarEntrenamient")
    public ResponseEntity<String> eliminarEntrenamiento(@RequestBody Map<String, String> datos) {
        try {
            // Obtener y validar datos de entrada
            Integer idEntrenamiento = Integer.parseInt(datos.get("idEntrenamiento"));
            
            // Llamar al servicio para eliminar el entrenamiento
            entrenamientoService.deleteEntrenamiento(idEntrenamiento);
                        return new ResponseEntity<>("Entrenamiento eliminado con éxito.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            
            return new ResponseEntity<>("Entrenamiento no encontrado: " + e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            
            return new ResponseEntity<>("Error al eliminar el entrenamiento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
