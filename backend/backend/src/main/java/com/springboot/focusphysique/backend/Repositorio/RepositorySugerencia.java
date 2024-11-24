package com.springboot.focusphysique.backend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Sugerencia;

public interface RepositorySugerencia extends JpaRepository<Sugerencia, Integer>{
    @Query("DELETE FROM Sugerencia s WHERE s.idSugerencia = :idSugerencia")
    @Modifying
    void deleteSugerenciaById(@Param("idSugerencia") Integer idSugerencia);
}
