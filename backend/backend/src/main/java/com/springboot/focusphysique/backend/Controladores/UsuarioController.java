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
import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
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
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario datosUsuario) {
        Usuario nuevoUsuario = usuarioService.crearUsuario(datosUsuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        } catch (RuntimeException e) {
            // Manejo de excepciones para cuando no se pueda eliminar el usuario
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar el usuario: " + e.getMessage());
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
    // Método para agregar un Entrenamiento a un usuario
    @PutMapping("/{id}/rutinaEntrenamiento/{idRutina}")
    public ResponseEntity<Usuario> agregarRutinaUsuario(
            @PathVariable Integer id, 
            @PathVariable Integer idRutina) {
        Usuario usuarioActualizado = usuarioService.agregarRutinaUsuario(id, idRutina);
        if (usuarioActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioActualizado);
    }

    @GetMapping("/{id}/entrenamiento")
    public ResponseEntity<?> getEntrenamiento(@PathVariable Integer id) {
        // Verificar si el entrenamiento existe
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        if (!usuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento con el ID proporcionado no está registrado.");
        }
        // Recuperar las sugerencias asociadas al ID del entrenamiento
        Set<Entrenamiento> entrenamientos = usuarioService.getEntrenamientosByUsuarioId(id);
        // Verificar si el entrenamiento tiene sugerencias
        if (entrenamientos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento existe pero no cuenta con sugerencias asociadas.");
        }
        // Retornar las sugerencias si existen
        return ResponseEntity.ok(entrenamientos);
    }

    @GetMapping("/{id}/rutinaEntrenamiento")
    public ResponseEntity<?> getRutina(@PathVariable Integer id) {
        // Verificar si el entrenamiento existe
        Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
        if (!usuario.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La Rutina con el ID proporcionado no está registrado.");
        }
        // Recuperar las sugerencias asociadas al ID del entrenamiento
        Set<Rutina_Entrenamiento> rutinas = usuarioService.getRutinasByUsuarioId(id);
        // Verificar si el entrenamiento tiene sugerencias
        if (rutinas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El entrenamiento existe pero no cuenta con Rutinas de entrenameinto asociadas.");
        }
        // Retornar las sugerencias si existen
        return ResponseEntity.ok(rutinas);
    }

    // Eliminar un entrenamiento por ID de usuario e ID de entrenamiento
    @DeleteMapping("/{id}/entrenamiento/{idEntrenamiento}")
    public ResponseEntity<Void> eliminarEntrenamiento(
            @PathVariable Integer id,
            @PathVariable Integer idEntrenamiento) {
        usuarioService.eliminarEntrenamientoPorUsuarioId(id, idEntrenamiento);
        return ResponseEntity.noContent().build();
    }
    // Eliminar un entrenamiento por ID de usuario e ID de entrenamiento
    @DeleteMapping("/{id}/rutinaEntrenamiento/{idRutina}")
    public ResponseEntity<Void> eliminarRutina(
            @PathVariable Integer id,
            @PathVariable Integer idRutina) {
        usuarioService.eliminarRutinaPorUsuarioId(id, idRutina);
        return ResponseEntity.noContent().build();
    }
}