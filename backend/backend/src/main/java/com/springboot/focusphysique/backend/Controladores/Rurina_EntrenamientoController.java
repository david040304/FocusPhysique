package com.springboot.focusphysique.backend.Controladores;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Servicio.IRutinaEntrenamientoServicio;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/rutina")
public class Rurina_EntrenamientoController {
    @Autowired
    private IRutinaEntrenamientoServicio rutinaServicio;

    @GetMapping
    public ResponseEntity<Iterable<Rutina_Entrenamiento>> getAllRutina() {
        return ResponseEntity.ok().body(rutinaServicio.obtenerRutinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rutina_Entrenamiento> getRutinaPorId(@PathVariable Integer id) {
        Optional<Rutina_Entrenamiento> opRutina = rutinaServicio.obtenerRutinaPorId(id);
        if (opRutina.isPresent()) {
            return ResponseEntity.ok().body(opRutina.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Rutina_Entrenamiento  crearRutinaEntrenamiento(@RequestBody Rutina_Entrenamiento entity) {
        return rutinaServicio.crearRutinaEntrenamiento(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Rutina_Entrenamiento> eliminarRutina(@PathVariable(name = "id") Integer id) {
        Optional<Rutina_Entrenamiento> rutina = rutinaServicio.eliminarRutina(id);
        if (rutina.isPresent()) {
            return ResponseEntity.ok().body(rutina.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rutina_Entrenamiento> actualizarRutina(@PathVariable(name = "id") Integer id,
            @RequestBody Rutina_Entrenamiento rutinaOld) {
                if (rutinaOld == null || rutinaOld.getNombre() == null || rutinaOld.getDescripcion() == null || rutinaOld.getDuracion() == null || rutinaOld.getNivel_Dificultad() == null) {
                    return ResponseEntity.badRequest().body(null);
                }
                // Buscar la cuenta existente por ID
                Optional<Rutina_Entrenamiento> RutinaOpt = rutinaServicio.obtenerRutinaPorId(id);
                if (RutinaOpt.isPresent()) {
                    Rutina_Entrenamiento RutinaNew = RutinaOpt.get();
                    // Actualizar campos necesarios
                    RutinaNew.setNombre(rutinaOld.getNombre());
                    RutinaNew.setDescripcion(rutinaOld.getDescripcion());
                    RutinaNew.setDuracion(rutinaOld.getDuracion());
                    RutinaNew.setNivel_Dificultad(rutinaOld.getNivel_Dificultad());
                    // Guardar cambios
                    Rutina_Entrenamiento rutinaactualizada = rutinaServicio.crearRutinaEntrenamiento(RutinaNew);
                    return ResponseEntity.ok(rutinaactualizada);
                }
                // Si no encuentra la cuenta, retornar 404
                return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/sugerencias")
    public Set<Sugerencia> obtenerSugerenciasPorRutinaId(@PathVariable Integer id) {
        return rutinaServicio.obtenerSugerenciasPorRutinaId(id);
    }

    // Método para agregar una sugerencia a un Rutina de entrenamiento
    @PutMapping("/{idRutina}/sugerencias/{idSugerencia}")
    public ResponseEntity<Rutina_Entrenamiento> agregarSugerencia(
            @PathVariable Integer idRutina,
            @PathVariable Integer idSugerencia) {
            Rutina_Entrenamiento rutinaActualizada = rutinaServicio.agregarSugerencia(idRutina, idSugerencia);
            if (rutinaActualizada == null){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(rutinaActualizada);
    }
}
