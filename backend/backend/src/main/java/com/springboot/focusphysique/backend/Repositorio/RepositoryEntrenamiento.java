package com.springboot.focusphysique.backend.Repositorio;
import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;

public interface RepositoryEntrenamiento extends JpaRepository<Entrenamiento, Integer>{
    
    //ejecutar procedimeinto para insert
    @Procedure(name = "insertar_entrenamiento")
    void insertEntrenamiento(
        @Param("P_Nombre_entrenamiento") String nombreEntrenamiento,
        @Param("P_Descripcion_entre") String descripcionEntrenamiento,
        @Param("P_Grupo_Muscular") String grupoMuscular,
        @Param("P_Lv_dificultad") String nivelDificultad,
        @Param("P_Genero") Character genero,
        @Param("P_MET") Double met,
        @Param("P_Id_Tipo_Entren") Integer idTipoEntrenamiento
    );
    //ejecuta procedimiento para update
    @Procedure(name = "Update_Entrenamiento")
    void updateEntrenamiento(
        @Param("P_Id_Entrenamiento") Integer idEntrenamiento,
        @Param("P_Nombre_entrenamiento") String nombreEntrenamiento,
        @Param("P_Descripcion_entre") String descripcionEntrenamiento,
        @Param("P_Grupo_Muscular") String grupoMuscular,
        @Param("P_Lv_dificultad") String nivelDificultad,
        @Param("P_Genero") Character genero,
        @Param("P_MET") Double met,
        @Param("P_Id_Tipo_Entren") Integer idTipoEntrenamiento
    );

    //ejecuta procedimiento para delete
    @Procedure(name = "Delete_Entrenamiento")
    void deleteEntrenamiento(@Param("P_Id_Entrenamiento") Integer idEntrenamiento);
        


}
