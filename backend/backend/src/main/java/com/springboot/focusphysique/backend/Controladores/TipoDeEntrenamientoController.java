package com.springboot.focusphysique.backend.Controladores;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.focusphysique.backend.Servicios.Tipo_de_EntrenamientoService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/TipoDeEntrenamiento")

public class TipoDeEntrenamientoController {

    @Autowired
    private Tipo_de_EntrenamientoService tipoDeEntrenamientoService;

    @PostMapping("/Insertar")
      public ResponseEntity<String> insertarTipoDeEntrenamiento(@RequestBody Map<String, String> datos) {

        try {//validacion de campos
            if(datos.get("P_Nombre_tipo")== null || datos.get("P_Descripcion")==null){
                return ResponseEntity.status(400).body("Error: Todos los campos son requeridos.");

            }

            //llamada al metodo insertar tipo de entrenamiento
            tipoDeEntrenamientoService.insertarTipoDeEntrenamiento(
                datos.get("P_Nombre_tipo").toString(),
                datos.get("P_Descripcion").toString()
            );
            //retorno de respuesta con exito
            return ResponseEntity.ok("Tipo de entrenamiento insertado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al insertar: " + e.getMessage());
        }
    }

    //update
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarTipoDeEntrenamiento(@RequestBody Map<String, Object> datos) {
        Integer idTipoEntren = (Integer) datos.get("P_Id_Tipo_Entren");
        String nombreTipo = (String) datos.get("P_Nombre_tipo");
        String descripcion = (String) datos.get("P_Descripcion");

        try {
            tipoDeEntrenamientoService.actualizarTipoDeEntrenamiento(idTipoEntren, nombreTipo, descripcion);
            return ResponseEntity.ok("Tipo de entrenamiento actualizado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al actualizar: " + e.getMessage());
        }
    }
    //delete
    @DeleteMapping("/Eliminar")
    public ResponseEntity<String> eliminarTipoDeEntrenamiento(@RequestParam Integer idTipoEntren) {
        try {
            tipoDeEntrenamientoService.eliminarTipoDeEntrenamiento(idTipoEntren);
            return ResponseEntity.ok("Tipo de entrenamiento eliminado con éxito.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar: " + e.getMessage());
        }
    }


}
