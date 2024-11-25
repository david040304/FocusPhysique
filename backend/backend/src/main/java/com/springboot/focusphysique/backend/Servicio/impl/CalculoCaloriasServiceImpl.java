package com.springboot.focusphysique.backend.Servicio.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;
import com.springboot.focusphysique.backend.Repositorio.RepositoryEntrenamiento;
import com.springboot.focusphysique.backend.Repositorio.RepositoryUsuario;
import com.springboot.focusphysique.backend.Servicio.ICalculoCaloriasService;

@Service
public class CalculoCaloriasServiceImpl implements ICalculoCaloriasService {
    @Autowired
    private RepositoryUsuario repoUsuario;
    @Autowired
    private RepositoryEntrenamiento repoEntre;

   /*  public CalculoCaloriasServiceImpl(RepositoryUsuario repoUsuario, RepositoryEntrenamiento repoEntre){
        this.repoUsuario = repoUsuario;
        this.repoEntre = repoEntre;
    }*/
    @Override
    public Double calcularCalorias(Integer id, Integer idEntrenamiento) throws IllegalArgumentException{

        Usuario usuario = repoUsuario.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Entrenamiento entrenamiento = repoEntre.findById(idEntrenamiento)
        .orElseThrow(() -> new IllegalArgumentException("El entrenamiento no existe"));

        if(usuario.getPeso_Inicio() == null || entrenamiento.getMet() == null || entrenamiento.getDuracion() == null){
            throw new IllegalArgumentException("Faltan datos para calcular las calorías");
        }
        // conversion  de time a minutos 
        int duracionMinutos = entrenamiento.getDuracion().toLocalTime().getHour()*60
                            + entrenamiento.getDuracion().toLocalTime().getMinute();
        // Fórmula de cálculo de calorías
        return entrenamiento.getMet() * 3.5 * usuario.getPeso_Inicio() * duracionMinutos / 200;

    }

}
