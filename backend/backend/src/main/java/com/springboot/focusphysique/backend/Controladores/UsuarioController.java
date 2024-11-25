package com.springboot.focusphysique.backend.Controladores;

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
import com.springboot.focusphysique.backend.Entidades.Usuario;
import com.springboot.focusphysique.backend.Servicio.IUsuarioServicio;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioServicio usuarioService;

    @GetMapping
    public ResponseEntity<Iterable<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok().body(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable Integer id) {
        Optional<Usuario> opUsuario = usuarioService.obtenerUsuarioPorId(id);
        if (opUsuario.isPresent()) {
            return ResponseEntity.ok().body(opUsuario.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario entity) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(entity);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable(name = "id") Integer id) {
        Optional<Usuario> usuario = usuarioService.eliminarUsuario(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok().body(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable(name = "id") Integer id,
            @RequestBody Usuario usuarioOld) {
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario.isPresent()) {
            Usuario usuarioNew = usuario.get();
            usuarioNew.setP_Nombre(usuarioOld.getP_Nombre());
            usuarioNew.setS_Nombre(usuarioOld.getS_Nombre());
            usuarioNew.setP_Apellido(usuarioOld.getP_Apellido());
            usuarioNew.setS_Apellido(usuarioOld.getS_Apellido());
            usuarioNew.setEdad(usuarioOld.getEdad());            
            usuarioNew.setTelefono(usuarioOld.getTelefono());
            usuarioNew.setGenero(usuarioOld.getGenero());
            usuarioNew.setAltura_Inicio(usuarioOld.getAltura_Inicio());
            usuarioNew.setPeso_Inicio(usuarioOld.getPeso_Inicio());
            return ResponseEntity.ok(usuarioService.crearUsuario(usuarioNew));
        }
        return ResponseEntity.notFound().build();
    }

    // Método para agregar un Entrenamiento a un usuario
    @PutMapping("/{id}/entrenamiento/{idEntrenamiento}")
    public ResponseEntity<Usuario> agregarEntrenamientUsuario(
            @PathVariable Integer id, 
            @PathVariable Integer idEntrenamiento) {
        Usuario usuarioActualizado = usuarioService.agregarEntrenamientUsuario(id, idEntrenamiento);
        if (usuarioActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioActualizado);
    }

    @GetMapping("/{id}/entrenamiento")
    public ResponseEntity<?> getEntrenamiento(@PathVariable Integer id) {
        // Verificar si el entrenamiento existe
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null || usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento con el ID proporcionado no está registrado.");
        }
        // Recuperar las sugerencias asociadas al ID del entrenamiento
        Set<Entrenamiento> entrenamientos = usuarioService.getEntrenamientosByUsuarioId(id);
        // Verificar si el entrenamiento tiene sugerencias
        if (entrenamientos == null || entrenamientos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento existe pero no cuenta con sugerencias asociadas.");
        }
        // Retornar las sugerencias si existen
        return ResponseEntity.ok(entrenamientos);
    }

    // Eliminar un entrenamiento por ID de usuario e ID de entrenamiento
    @DeleteMapping("/{idUsuario}/entrenamientos/{idEntrenamiento}")
    public ResponseEntity<Void> eliminarEntrenamiento(
            @PathVariable Integer idUsuario,
            @PathVariable Integer idEntrenamiento) {
        usuarioService.eliminarEntrenamientoPorUsuarioId(idUsuario, idEntrenamiento);
        return ResponseEntity.noContent().build();
    }
}