package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Usuario;
import com.springboot.focusphysique.backend.Repositorio.RepositoryUsuario;
import com.springboot.focusphysique.backend.Servicio.IUsuarioServicio;

@Service
public class UsuarioServiceImpl implements IUsuarioServicio{
    @Autowired
    private RepositoryUsuario repo;

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
}
