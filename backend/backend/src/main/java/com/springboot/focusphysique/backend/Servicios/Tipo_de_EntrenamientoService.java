package com.springboot.focusphysique.backend.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.focusphysique.backend.Repositorio.RepositoryTipoDeEntrenamiento;

@Service
public class Tipo_de_EntrenamientoService {

    @Autowired
    private RepositoryTipoDeEntrenamiento repositoryTipoDeEntrenamiento;
    // metodo insert

    public void insertarTipoDeEntrenamiento(String P_Nombre_tipo, String P_Descripcion) {
        repositoryTipoDeEntrenamiento.insertTipoDeEntrenamiento(P_Nombre_tipo, P_Descripcion);
    }

    // metodo update
    public void actualizarTipoDeEntrenamiento(Integer P_Id_Tipo_Entren, String P_Nombre_tipo, String P_Descripcion) {
        repositoryTipoDeEntrenamiento.updateTipoDeEntrenamiento(P_Id_Tipo_Entren, P_Nombre_tipo, P_Descripcion);
    }
    // metodo delete
    public void eliminarTipoDeEntrenamiento(Integer P_Id_Tipo_Entren) {
        repositoryTipoDeEntrenamiento.deleteTipoDeEntrenamiento(P_Id_Tipo_Entren);
    }



}
