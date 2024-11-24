package com.springboot.focusphysique.backend.Repositorio;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;



public interface RepositoryEntrenamiento extends JpaRepository<Entrenamiento, Integer>{
    @Query("SELECT e.sugerencias FROM Entrenamiento e WHERE e.idEntrenamiento = :idEntrenamiento")
    Set<Sugerencia> findSugerenciasByEntrenamientoId(@Param("idEntrenamiento") Integer idEntrenamiento);
    
    /*Query para eliminar la relación entre entrenamiento y sugerencia en la tabla intermedia
    @Query(value = "DELETE FROM registro_sugerencia WHERE id_entrenamiento = :idEntrenamiento AND id_sugerencia = :idSugerencia", nativeQuery = true)
    void eliminarRelacion(@Param("idEntrenamiento") Integer idEntrenamiento, @Param("idSugerencia") Integer idSugerencia);*/
}
