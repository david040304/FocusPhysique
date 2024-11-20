package com.springboot.focusphysique.backend.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.focusphysique.backend.Repositorio.RepositoryTipoDeEntrenamiento;

@Service
public class Tipo_de_EntrenamientoService {

    @Autowired
    private RepositoryTipoDeEntrenamiento repositoryTipoDeEntrenamiento;
    // metodo insert

    public void insertarTipoDeEntrenamiento(String nombreTipo, String descripcion) {
        repositoryTipoDeEntrenamiento.insertTipoDeEntrenamiento(nombreTipo, descripcion);
    }

    // metodo update
    public void actualizarTipoDeEntrenamiento(Integer idTipoEntren, String nombreTipo, String descripcion) {
        repositoryTipoDeEntrenamiento.updateTipoDeEntrenamiento(idTipoEntren, nombreTipo, descripcion);
    }
    // metodo delete
    public void eliminarTipoDeEntrenamiento(Integer idTipoEntren) {
        repositoryTipoDeEntrenamiento.deleteTipoDeEntrenamiento(idTipoEntren);
    }



}
