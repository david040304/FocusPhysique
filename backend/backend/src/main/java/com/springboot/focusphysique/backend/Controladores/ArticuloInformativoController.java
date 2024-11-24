package com.springboot.focusphysique.backend.Controladores;

import java.util.List;
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

import com.springboot.focusphysique.backend.Entidades.Articulos_Info;
import com.springboot.focusphysique.backend.Servicio.IArticuloServicio;

@RestController
@RequestMapping("api/articulo")
public class ArticuloInformativoController {
    @Autowired
    private IArticuloServicio articuloServicio;

    @PostMapping("/{id}")
    public ResponseEntity<Articulos_Info> crearArticulo(
            @PathVariable Integer id,
            @RequestBody Articulos_Info datosArticulo) {
        Articulos_Info articulo = articuloServicio.crearArticuloInformativo(id, datosArticulo);
        return new ResponseEntity<>(articulo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Articulos_Info>> obtenerTodosArticulos() {
        List<Articulos_Info> articulos = articuloServicio.obtenerArticulos();
        return articulos.isEmpty() 
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
                : new ResponseEntity<>(articulos, HttpStatus.OK);
    }

    @GetMapping("/administrador/{id}")
    public ResponseEntity<List<Articulos_Info>> obtenerArticulosPorAdministrador(@PathVariable Integer id) {
        List<Articulos_Info> articulos = articuloServicio.obtenerArticulosPorAdministrador(id);
        return articulos.isEmpty() 
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
                : new ResponseEntity<>(articulos, HttpStatus.OK);
}

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Articulos_Info> actualizarArticulo(
            @PathVariable Integer id,
            @RequestBody Articulos_Info datosArticulo) {
        Articulos_Info articuloActualizado = articuloServicio.actualizarArticuloInformativo(id, datosArticulo);
        return ResponseEntity.ok(articuloActualizado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarArticulo(@PathVariable Integer id) {
        articuloServicio.eliminarArticuloInformativo(id);
        return ResponseEntity.noContent().build();
    }
}
