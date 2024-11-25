package com.springboot.focusphysique.backend.Servicio;

import java.util.Optional;
import java.util.Set;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;

public interface IUsuarioServicio {
    Usuario crearUsuario(Usuario datosUsuario);
    Optional<Usuario> obtenerUsuarioPorId(Integer id);
    Iterable<Usuario> obtenerUsuarios();
    Optional<Usuario> eliminarUsuario(Integer id);
    Set<Entrenamiento> getEntrenamientosByUsuarioId(Integer id);
    Usuario agregarEntrenamientUsuario(Integer id, Integer idEntrenamiento);
}
