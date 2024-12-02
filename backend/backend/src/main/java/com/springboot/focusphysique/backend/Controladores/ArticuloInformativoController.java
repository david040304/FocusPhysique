package com.springboot.focusphysique.backend.Controladores;

import java.util.List;

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

import com.springboot.focusphysique.backend.Dto.Articulo_InfoDto;
import com.springboot.focusphysique.backend.Entidades.Articulos_Info;
import com.springboot.focusphysique.backend.Servicio.IArticuloServicio;

@RestController
@RequestMapping("api/articulo")
public class ArticuloInformativoController {
    @Autowired
    private IArticuloServicio articuloServicio;

    @PostMapping
    public ResponseEntity<Articulo_InfoDto> crearArticulo(@RequestBody Articulo_InfoDto entity ) {
        Articulo_InfoDto articulo = articuloServicio.crearArticuloInformativo(entity);
        return new ResponseEntity<>(articulo, HttpStatus.CREATED);
  
    }

    @GetMapping
    public ResponseEntity<List<Articulo_InfoDto>> obtenerTodosArticulos() {
        List<Articulo_InfoDto> articulos = articuloServicio.obtenerArticulos();
        return articulos.isEmpty() 
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
                : new ResponseEntity<>(articulos, HttpStatus.OK);
    }

    @GetMapping("/administrador/{id}")
    public ResponseEntity<List<Articulo_InfoDto>> obtenerArticulosPorAdministrador(@PathVariable Integer id) {
        List<Articulo_InfoDto> articulos = articuloServicio.obtenerArticulosPorAdministrador(id);
        return articulos.isEmpty() 
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
                : new ResponseEntity<>(articulos, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Articulo_InfoDto> actualizarArticulo(@PathVariable (name = "id") Integer idArticulo,
    @RequestBody Articulo_InfoDto datosArticulo) {
        Articulo_InfoDto articuloActualizado = articuloServicio.updateArticulo(idArticulo, datosArticulo);
        return ResponseEntity.ok(articuloActualizado);
   
        
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarArticulo(@PathVariable Integer id) {
        articuloServicio.eliminarArticuloInformativo(id);
        return ResponseEntity.ok("Articulo deleted successfully");
    }
}
