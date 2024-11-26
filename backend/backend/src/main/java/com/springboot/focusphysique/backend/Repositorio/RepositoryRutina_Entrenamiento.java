package com.springboot.focusphysique.backend.Repositorio;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;

import jakarta.transaction.Transactional;


public interface RepositoryRutina_Entrenamiento extends JpaRepository<Rutina_Entrenamiento, Integer> {
    @Query("SELECT r.sugerencias FROM Rutina_Entrenamiento r WHERE r.idRutina = :idRutina")
    Set<Sugerencia> findSugerenciasByRutinaId(@Param("idRutina") Integer idRutina);

    @Modifying
    @Transactional
    @Query(
        value = "DELETE FROM registro_Rutina_sugerencia rs WHERE rs.id_rutina = :idRutina AND rs.id_sugerencia = :idSugerencia",
        nativeQuery = true
    )
    void deleteSugerenciaByRutinaId(@Param("idRutina") Integer idRutina, @Param("idSugerencia") Integer idSugerencia);

    
}
