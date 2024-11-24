package com.springboot.focusphysique.backend.Repositorio;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;


public interface RepositoryRutina_Entrenamiento extends JpaRepository<Rutina_Entrenamiento, Integer> {
    @Query("SELECT r.sugerencias FROM Rutina_Entrenamiento r WHERE r.idRutina = :idRutina")
    Set<Sugerencia> findSugerenciasByRutinaId(@Param("idRutina") Integer idRutina);
}
