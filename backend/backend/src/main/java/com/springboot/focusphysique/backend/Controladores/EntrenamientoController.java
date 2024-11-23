package com.springboot.focusphysique.backend.Controladores;

import java.util.Optional;

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
    @DeleteMapping("/{id}")
    public ResponseEntity<Entrenamiento> eliminarEntren(@PathVariable(name = "id") Integer id){
        Optional<Entrenamiento> Entren = servicio.eliminarEntren(id);
        if (Entren.isPresent()){
            return ResponseEntity.ok().body(Entren.get());
        }
        return ResponseEntity.notFound().build();
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
                    entrenNew.setMet(entrenOld.getMet());
                    return ResponseEntity.ok(servicio.crearEntrenamiento(entrenNew));
                    
                }
                return ResponseEntity.notFound().build();

            }
  

}
