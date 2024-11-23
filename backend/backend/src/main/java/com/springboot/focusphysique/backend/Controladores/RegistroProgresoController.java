package com.springboot.focusphysique.backend.Controladores;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.focusphysique.backend.Entidades.Registro_progreso;
import com.springboot.focusphysique.backend.Servicio.IRegistroProgresoService;

@RestController
@RequestMapping("/api/registroProgreso")
public class RegistroProgresoController {
    @Autowired
    private IRegistroProgresoService registroProgresoService;

    @GetMapping
    public ResponseEntity<Iterable<Registro_progreso>> getAllRegsitro_progresos() {
        return ResponseEntity.ok().body(registroProgresoService.obtenerRegistro_progresos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro_progreso> getUsuarioPorId(@PathVariable Integer id) {
        Optional<Registro_progreso> opRegistroProgreso = registroProgresoService.obtenerRegsitro_progresoPorId(id);
        if (opRegistroProgreso.isPresent()) {
            return ResponseEntity.ok().body(opRegistroProgreso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Registro_progreso> crearRegistro_progreso(@RequestBody Registro_progreso entity) {
        Registro_progreso nuevoPorgreso = registroProgresoService.crearRegistro_progreso(entity);
        return new ResponseEntity<>(nuevoPorgreso, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Registro_progreso> eliminarUsuario(@PathVariable(name = "id") Integer id) {
        Optional<Registro_progreso> progreso = registroProgresoService.eliminarRegistro_progreso(id);
        if (progreso.isPresent()) {
            return ResponseEntity.ok().body(progreso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
