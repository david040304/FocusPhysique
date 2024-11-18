package com.springboot.focusphysique.backend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Tipo_de_Entrenamiento;

public interface RepositoryTipoDeEntrenamiento extends JpaRepository<Tipo_de_Entrenamiento, Integer> {

    //ejecutar el procedimiento de insert
    @Procedure(name="Insert_Tipo_de_Entrenamiento")
    void insertTipoDeEntrenamiento(
        @Param("P_Nombre_tipo") String P_Nombre_tipo,
        @Param("P_Descripcion") String P_Descripcion
    );

    //ejecutar el procedimiento de update
    @Procedure(name="Update_Tipo_de_Entrenamiento")
    void updateTipoDeEntrenamiento(
        @Param("P_Id_Tipo_Entren") Integer P_Id_Tipo_Entren,
        @Param("P_Nombre_tipo") String P_Nombre_tipo,
        @Param("P_Descripcion") String P_Descripcion
    );

    //ejecutar el procedimiento de delete
    @Procedure(name="Delete_Tipo_de_Entrenamiento")
    void deleteTipoDeEntrenamiento(
        @Param("P_Id_Tipo_Entren") Integer P_Descripcion
    );

}
