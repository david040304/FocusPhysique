package com.springboot.focusphysique.backend.Controladores;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Entidades.Tipo_de_Entrenamiento;
import com.springboot.focusphysique.backend.Servicio.ITipoDeEntrenamientoServicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/Tipos")

public class TipoDeEntrenamientoController {
    @Autowired
    private ITipoDeEntrenamientoServicio tipoServicio;
    //Configurar metodo crearTipo
    @PostMapping
    public Tipo_de_Entrenamiento crearTipo(@RequestBody Tipo_de_Entrenamiento entity ){
        return tipoServicio.crearTipo(entity);
    }
    //configurar metodo obtenerTipoPorId
    @GetMapping("/{id}")
    public ResponseEntity<Tipo_de_Entrenamiento> getTipoPorId(@PathVariable Integer id){
        Optional<Tipo_de_Entrenamiento> opTipo = tipoServicio.obtenerTipoPorId(id);
        if(opTipo.isPresent()){
            return ResponseEntity.ok().body(opTipo.get());
        }
        return ResponseEntity.notFound().build();
    }
    //configurar metodo obtenerTipos
    @GetMapping
    public ResponseEntity<Iterable<Tipo_de_Entrenamiento>> getAllTipos(){
        return ResponseEntity.ok().body(tipoServicio.obtenerTipos());
    }
    //configurar metodo eliminarTipo
    @DeleteMapping("{id}")
    public ResponseEntity<Tipo_de_Entrenamiento> eliminarTipos(@PathVariable(name = "id") Integer id){
        Optional<Tipo_de_Entrenamiento> tipo =  tipoServicio.eliminarTipo(id);
        if(tipo.isPresent()){
            return ResponseEntity.ok().body(tipo.get());
        }
        return ResponseEntity.notFound().build();
    }
    //configurar metodo actualizarTipo
    @PutMapping("/{id}")
    public ResponseEntity<Tipo_de_Entrenamiento> actualizarTipo(@PathVariable(name = "id") Integer id,
            @RequestBody Tipo_de_Entrenamiento tipoOld){
                if (tipoOld == null || tipoOld.getNombreTipo() == null || tipoOld.getDescripcion() == null){
                    return ResponseEntity.badRequest().body(null);
                }
                //buscar el tipo si existe
                Optional<Tipo_de_Entrenamiento> tipoOpt = tipoServicio.obtenerTipoPorId(id);
                if(tipoOpt.isPresent()){
                    Tipo_de_Entrenamiento tipoNew = tipoOpt.get();
                    // Actualizar los campos necesarios
                    tipoNew.setNombreTipo(tipoOld.getNombreTipo());
                    tipoNew.setDescripcion(tipoOld.getDescripcion());
                    //Guardar los cambios
                    Tipo_de_Entrenamiento tipoActualizado = tipoServicio.crearTipo(tipoNew);
                    return ResponseEntity.ok(tipoActualizado);
                }
                // si no da error 404
                return ResponseEntity.notFound().build();
            }
    


}
