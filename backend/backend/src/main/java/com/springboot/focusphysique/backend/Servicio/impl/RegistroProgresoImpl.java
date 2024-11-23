package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Registro_progreso;
import com.springboot.focusphysique.backend.Repositorio.RepositoryRegistroProgreso;
import com.springboot.focusphysique.backend.Servicio.IRegistroProgresoService;

@Service
public class RegistroProgresoImpl implements IRegistroProgresoService{
    @Autowired
    private RepositoryRegistroProgreso repo;

    @Override
    public Registro_progreso crearRegistro_progreso(Registro_progreso datosProgreso) {
        return repo.save(datosProgreso);
    }

    @Override
    public Optional<Registro_progreso> obtenerRegsitro_progresoPorId(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Iterable<Registro_progreso> obtenerRegistro_progresos() {
        return repo.findAll();
    }

    @Override
    public Optional<Registro_progreso> eliminarRegistro_progreso(Integer id) {
        return repo.findById(id).map(Registro_progreso -> {
            repo.delete(Registro_progreso);
            return Registro_progreso;
        });
    }
    
    
}
