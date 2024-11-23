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

import com.springboot.focusphysique.backend.Entidades.Sugerencia;
import com.springboot.focusphysique.backend.Servicio.ISugerenciaSercio;

@RestController
@RequestMapping("/api/Sugerencia")
public class SugerenciaController {
     // Configurar los métodos
    @Autowired
    private ISugerenciaSercio Servicio;
   

    // Métodos para crear
    @PostMapping
    public ResponseEntity<Sugerencia> crearSugerencia(@RequestBody Sugerencia entity){
        Sugerencia nuevaSugerencia = Servicio.crearSugerencia(entity);
        return new ResponseEntity<>(nuevaSugerencia, HttpStatus.CREATED);
    }

    // Métodos para obtenerSugerenciaId
    @GetMapping("/{id}")
    public ResponseEntity<Sugerencia> getSugerenciaPorId(@PathVariable Integer id){
        Optional<Sugerencia> opSugerencia = Servicio.obtenerSugerenciaId(id);
        if(opSugerencia.isPresent()){
            return ResponseEntity.ok().body(opSugerencia.get());
        }
        return ResponseEntity.notFound().build();
        
    }
    // Métodos para obtener todas las sugerencias
    @GetMapping
    public ResponseEntity<Iterable<Sugerencia>> obtenerSugerencias(){
        
        return ResponseEntity.ok().body(Servicio.obtenerSugerencias());
    }

    // Métodos para eliminar sugerencia
    @DeleteMapping("/{id}")
    public ResponseEntity<Sugerencia> eliminarSugerencia(@PathVariable Integer id){
        Optional<Sugerencia> opSugerencia = Servicio.eliminarSugerencia(id);
        if(opSugerencia.isPresent()){
            return ResponseEntity.ok().body(opSugerencia.get());
        }
        return ResponseEntity.notFound().build();
    }

    //método actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<Sugerencia> actualizarSugerencia(@PathVariable(name = "id") Integer id, 
    @RequestBody Sugerencia sugerenciaOld ){
        Optional<Sugerencia> Sugerencia = Servicio.obtenerSugerenciaId(id);
        if(Sugerencia.isPresent()){
            Sugerencia SugerenciaNew = Sugerencia.get();
            SugerenciaNew.setDescripcion(sugerenciaOld.getDescripcion());
            SugerenciaNew.setTipoSugerencia(sugerenciaOld.getTipoSugerencia());
            return ResponseEntity.ok(Servicio.crearSugerencia(SugerenciaNew));
        }
        return ResponseEntity.notFound().build();
    }

    


}
