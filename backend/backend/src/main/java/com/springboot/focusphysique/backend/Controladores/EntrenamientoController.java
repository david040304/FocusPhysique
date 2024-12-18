package com.springboot.focusphysique.backend.Controladores;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Servicio.IEntrenamientoServicio;

@RestController
@RequestMapping("/api/Entrenamiento")
public class EntrenamientoController {

    @Autowired
    private IEntrenamientoServicio servicio;

    //configuracion del metodo crearEntrenamiento
    @PostMapping
    public ResponseEntity<Entrenamiento> crearEntrenamiento(@RequestBody Entrenamiento datosEntrenamiento ){
        Entrenamiento nuevoEntren = servicio.crearEntrenamiento(datosEntrenamiento);
        return new ResponseEntity<>(nuevoEntren, HttpStatus.CREATED);
    }

    //configuracion del metodo obtenerEntrenPorId
    @GetMapping("/{id}")
    public ResponseEntity<Entrenamiento> getEntrenPorId(@PathVariable Integer id){
        Optional <Entrenamiento> opEntren = servicio.obtenerEntrenPorId(id);
        if (opEntren.isPresent()){
            return ResponseEntity.ok().body(opEntren.get());

        }
        return ResponseEntity.notFound().build();
    }

    //configuracion del metodo obtenerEntren
    @GetMapping
    public ResponseEntity<Iterable<Entrenamiento>> getAllEntrenamiento(){
        return ResponseEntity.ok().body(servicio.obtenerEntren());
    }
    
    //configuracion del metodo eliminarEntren
    @DeleteMapping("/{idEntrenamiento}")
    public ResponseEntity<String> deleteSugerencia(@PathVariable("idEntrenamiento") Integer idEntrenamiento){
        servicio.eliminarEntren(idEntrenamiento);
        return ResponseEntity.ok("Entrenamiento deleted successfully");
    }

    //configuracion del metodo actualizarEntrenamiento
    @PutMapping("/{id}")
    public ResponseEntity<Entrenamiento> actualizarEntrenamiento(@PathVariable(name = "id") Integer id,
            @RequestBody Entrenamiento entrenOld){
                Optional<Entrenamiento> Entren = servicio.obtenerEntrenPorId(id);
                if(Entren.isPresent()){
                    Entrenamiento entrenNew = Entren.get();
                    entrenNew.setNombreEntrenamiento(entrenOld.getNombreEntrenamiento());
                    entrenNew.setDescripcionEntrenamiento(entrenOld.getDescripcionEntrenamiento());
                    entrenNew.setGrupoMuscular(entrenOld.getGrupoMuscular());
                    entrenNew.setNivelDificultad(entrenOld.getNivelDificultad());
                    entrenNew.setGenero(entrenOld.getGenero());
                    entrenNew.setDuracion(entrenOld.getDuracion());
                    entrenNew.setMet(entrenOld.getMet());
                    return ResponseEntity.ok(servicio.crearEntrenamiento(entrenNew));
                    
                }
                return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/sugerencias")
    public ResponseEntity<?> getSugerencias(@PathVariable Integer id) {
        // Verificar si el entrenamiento existe
        Optional<Entrenamiento> entrenamientos = servicio.obtenerEntrenPorId(id);
        if (entrenamientos == null || entrenamientos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento con el ID proporcionado no está registrado.");
        }
        // Recuperar las sugerencias asociadas al ID del entrenamiento
        Set<Sugerencia> sugerencias = servicio.getSugeSerenciasByEntrenamientoId(id);
        // Verificar si el entrenamiento tiene sugerencias
        if (sugerencias == null || sugerencias.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento existe pero no cuenta con sugerencias asociadas.");
        }
        // Retornar las sugerencias si existen
        return ResponseEntity.ok(sugerencias);
    }
    
    // Método para agregar una sugerencia a un entrenamiento
    @PutMapping("/{idEntrenamiento}/sugerencias/{idSugerencia}")
    public ResponseEntity<Entrenamiento> agregarSugerencia(
            @PathVariable Integer idEntrenamiento, 
            @PathVariable Integer idSugerencia) {
        Entrenamiento entrenamientoActualizado = servicio.agregarSugerencia(idEntrenamiento, idSugerencia);
        if (entrenamientoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entrenamientoActualizado);
    }

    // Eliminar una Sugerencia por ID de Sugerencia e ID de entrenamiento
    @DeleteMapping("/{idEntrenamiento}/entrenamientos/{idSugerencia}")
    public ResponseEntity<Void> eliminarSugerencia(
            @PathVariable Integer idEntrenamiento,
            @PathVariable Integer idSugerencia) {
        servicio.eliminarSugerenciaPorEntrenamientoId(idEntrenamiento, idSugerencia);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para obtener entrenamientos por género
    @GetMapping("/genero/{genero}")
    public List<Entrenamiento> obtenerEntrenamientosPorGenero(@PathVariable Character genero) {
        return servicio.findByGenero(genero);
    }

    // Endpoint para obtener entrenamientos por nivel de dificultad
    @GetMapping("/nivelDificultad/{nivelDificultad}")
    public List<Entrenamiento> obtenerEntrenamientosPorNivelDificultad(@PathVariable String nivelDificultad) {
        return servicio.findByNivelDificultad(nivelDificultad);
    }

    // Endpoint para obtener entrenamientos por grupo muscular
    @GetMapping("/grupoMuscular/{grupoMuscular}")
    public List<Entrenamiento> obtenerEntrenamientosPorGrupoMuscular(@PathVariable String grupoMuscular) {
        return servicio.findByGrupoMuscular(grupoMuscular);
    }

    @GetMapping("/filtro/tipo/{nombreTipo}")
public ResponseEntity<List<Entrenamiento>> getEntrenamientosPorTipo(@PathVariable String nombreTipo) {
    List<Entrenamiento> entrenamientos = servicio.findByTipoDeEntrenamientoNombre(nombreTipo);
    if (entrenamientos.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null); // Devuelve un código 404 si no hay resultados
    }
    return ResponseEntity.ok(entrenamientos); // Devuelve los entrenamientos filtrados
}
}
