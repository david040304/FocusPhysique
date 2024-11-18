package com.springboot.focusphysique.backend.Repositorio;

import java.sql.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;

public interface RepositoryRutina_Entrenamiento extends JpaRepository<Rutina_Entrenamiento, Integer> {
    @Procedure(name = "Insert_Rutina_Entrenamiento")
    void insertRutina_Entrenamiento(
        @Param("P_Nombre") String nombre,
        @Param("P_Descripcion") String descripcion,
        @Param("P_Duracion") Time duracion,
        @Param("P_Lv_dificultad") String nivel_Dificultad);

    // Llamada al procedimiento almacenado para eliminar una Rutina de entrenamiento
    @Procedure(name = "Delete_Rutina_Entrenamiento")
    void eliminar_Rutina_Entrenamiento(@Param("P_Id_rutina") Integer id_usuario);

    @Procedure(name = "Update_Rutina_Entrenamiento")
    void updateRutina(
        @Param("P_Id_rutina") Integer id_Rutina,
        @Param("P_Nombre") String nombre,
        @Param("P_Descripcion") String descripcion,
        @Param("P_Duracion") Time duracion,
        @Param("P_Lv_dificultad") String nivel_Dificultad
    );
}
