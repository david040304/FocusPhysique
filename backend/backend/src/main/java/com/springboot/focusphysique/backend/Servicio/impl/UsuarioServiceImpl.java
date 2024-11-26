package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;
import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryUsuario;
import com.springboot.focusphysique.backend.Servicio.IUsuarioServicio;

@Service
public class UsuarioServiceImpl implements IUsuarioServicio{
    @Autowired
    private RepositoryUsuario repo;

    @Autowired
    private RepositoryEntrenamiento repoEntrenamiento;

    @Override
    public Usuario crearUsuario(Usuario datosUsuario) {
        return repo.save(datosUsuario);
    }

    @Override
    public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Usuario> obtenerUsuarios() {
        return repo.findAll();
    }

    @Override
    public Optional<Usuario> eliminarUsuario(Integer id) {
        return repo.findById(id).map(usuario -> {
            repo.delete(usuario);
            return usuario;
        });
    }

    @Override
    public Set<Entrenamiento> getEntrenamientosByUsuarioId(Integer id) {
        return repo.findEntrenamientoByUsuarioId(id);
    }

    @Override
    public Usuario agregarEntrenamientUsuario(Integer id, Integer idEntrenamiento) {
        Optional<Usuario> usuario = repo.findById(id);
        Optional<Entrenamiento> entrenamiento = repoEntrenamiento.findById(idEntrenamiento);
        if(!usuario.isPresent() || !entrenamiento.isPresent()) {
            return null; // Si no se encuentra el usuario o el entrenamiento, no se puede agregar
        }
        usuario.get().getEntrenamiento().add(entrenamiento.get());
        return repo.save(usuario.get());
    }

    @Override
    public void eliminarEntrenamientoPorUsuarioId(Integer id, Integer idEntrenamiento) {
        repo.deleteEntrenamientoByUsuarioId(id, idEntrenamiento);
    }

    
}
