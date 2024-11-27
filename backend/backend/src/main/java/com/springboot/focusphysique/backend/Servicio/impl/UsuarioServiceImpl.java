package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;
import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryRutina_Entrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryUsuario;
import com.springboot.focusphysique.backend.Servicio.IUsuarioServicio;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioServicio{
    @Autowired
    private RepositoryUsuario repo;

    @Autowired
    private RepositoryRutina_Entrenamiento repoRutina;

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

    @Transactional
    public void eliminarUsuario(Integer id) {
        try {
            // Encontrar al usuario
            Usuario usuario = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            // Limpiar las relaciones de las tablas intermedias
            usuario.getEntrenamiento().clear(); // Eliminar las asociaciones en 'registro_entrenamiento'
            usuario.getRutina_Entrenamiento().clear(); // Eliminar las asociaciones en 'regsitro_rutina'

            // Eliminar el usuario
            repo.delete(usuario);

        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No se puede eliminar el usuario debido a dependencias en otras tablas.", e);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el usuario: " + e.getMessage(), e);
        }
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
    public Usuario agregarRutinaUsuario(Integer id, Integer idRutina) {
        Optional<Usuario> usuario = repo.findById(id);
        Optional<Rutina_Entrenamiento> rutina = repoRutina.findById(idRutina);
        if(!usuario.isPresent() || !rutina.isPresent()) {
            return null; // Si no se encuentra el usuario o el entrenamiento, no se puede agregar
        }
        usuario.get().getRutina_Entrenamiento().add(rutina.get());
        return repo.save(usuario.get());
    }

    @Override
    public void eliminarEntrenamientoPorUsuarioId(Integer id, Integer idEntrenamiento) {
        repo.deleteEntrenamientoByUsuarioId(id, idEntrenamiento);
    }

    @Override
    public void eliminarRutinaPorUsuarioId(Integer id, Integer idRutina) {
        repo.deleteRutinaByUsuarioId(id, idRutina);
    }

    @Override
    public Set<Rutina_Entrenamiento> getRutinasByUsuarioId(Integer id) {
        return repo.findRutinaByUsuarioId(id);
    }
}
