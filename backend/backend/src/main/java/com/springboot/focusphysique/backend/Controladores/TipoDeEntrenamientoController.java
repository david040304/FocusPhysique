package com.springboot.focusphysique.backend.Controladores;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Servicios.Tipo_de_EntrenamientoService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/TipoDeEntrenamiento")


public class TipoDeEntrenamientoController {

    @Autowired
    private Tipo_de_EntrenamientoService tipoDeEntrenamientoService;

    @PostMapping("/Insertar")
      public ResponseEntity<String> insertarTipoDeEntrenamiento(@RequestBody Map<String, String> datos) {
        String nombreTipo = datos.get("nombreTipo");
        String descripcion = datos.get("descripcion");

        try {
            tipoDeEntrenamientoService.insertarTipoDeEntrenamiento(nombreTipo, descripcion);
            return ResponseEntity.ok("Tipo de entrenamiento insertado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al insertar: " + e.getMessage());
        }
    }

    //update
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarTipoDeEntrenamiento(@RequestBody Map<String, Object> datos) {
        Integer id = (Integer) datos.get("id");
        String nombreTipo = (String) datos.get("nombreTipo");
        String descripcion = (String) datos.get("descripcion");

        try {
            tipoDeEntrenamientoService.actualizarTipoDeEntrenamiento(id, nombreTipo, descripcion);
            return ResponseEntity.ok("Tipo de entrenamiento actualizado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar: " + e.getMessage());
        }
    }
    //delete
    @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarTipoDeEntrenamiento(@RequestParam Integer id) {
        try {
            tipoDeEntrenamientoService.eliminarTipoDeEntrenamiento(id);
            return ResponseEntity.ok("Tipo de entrenamiento eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar: " + e.getMessage());
        }
    }


}
