package com.springboot.focusphysique.backend.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Dto.SugerenciaDto;
import com.springboot.focusphysique.backend.Servicio.ISugerenciaSercio;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/Sugerencia")
public class SugerenciaController {
     // Configurar los métodos
    @Autowired
    private ISugerenciaSercio Servicio;

    // Métodos para crear
    @PostMapping
    public ResponseEntity<SugerenciaDto> crearSugerencia(@RequestBody SugerenciaDto entity){
        SugerenciaDto nuevaSugerencia = Servicio.crearSugerencia(entity);
        return new ResponseEntity<>(nuevaSugerencia, HttpStatus.CREATED);
    }

    // Métodos para obtenerSugerenciaId
    @GetMapping("/{id}")
    public ResponseEntity<SugerenciaDto> getSugerenciaPorId(@PathVariable("id") Integer idSugerencia){
        SugerenciaDto sugerenciaDto = Servicio.obtenerSugerenciaId(idSugerencia);
        return ResponseEntity.ok(sugerenciaDto);
        
    }
    // Métodos para obtener todas las sugerencias
    @GetMapping
    public ResponseEntity<List<SugerenciaDto>> getAllSugerencias(){
        List<SugerenciaDto> sugerencias = Servicio.getAllSugerencias();
        return ResponseEntity.ok(sugerencias);
    }

    // Métodos para eliminar sugerencia
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSugerencia(@PathVariable("id") Integer idSugerencia){
        Servicio.deleteSugerencia(idSugerencia);
        return ResponseEntity.ok("Sugerencia deleted successfully");
    }

    //método actualizar 
    @PutMapping("/{id}")
    public ResponseEntity<SugerenciaDto> updateSugerencia(@PathVariable(name = "id") Integer idSugerencia, 
    @RequestBody SugerenciaDto updatSugerencia){
        SugerenciaDto sugerenciaDto = Servicio.updateSugerencia(idSugerencia, updatSugerencia);
        return ResponseEntity.ok(sugerenciaDto);
    }

    


}
