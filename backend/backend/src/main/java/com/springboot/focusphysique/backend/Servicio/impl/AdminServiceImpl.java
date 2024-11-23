package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.focusphysique.backend.Entidades.Administrador;
import com.springboot.focusphysique.backend.Repositorio.RepositoryAdmin;
import com.springboot.focusphysique.backend.Servicio.IAdminServicio;

@Service
public class AdminServiceImpl implements IAdminServicio {

    @Autowired
    private RepositoryAdmin repo;

    @Override
    public Administrador crearAdministrador(Administrador datosAdmin) {
        return repo.save(datosAdmin);
    }

    @Override
    public Optional<Administrador> obtenerAdminPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Administrador> obtenerAdmin() {
        return repo.findAll();
    }

    @Override
    public Optional<Administrador> eliminarAdmin(Integer id) {
        return repo.findById(id).map(Administrador ->{
            repo.delete(Administrador);
            return Administrador;

        });
    }


}
