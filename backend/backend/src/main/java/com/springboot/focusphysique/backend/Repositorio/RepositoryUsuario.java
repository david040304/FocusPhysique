package com.springboot.focusphysique.backend.Repositorio;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;

import jakarta.transaction.Transactional;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u.Entrenamiento FROM Usuario u WHERE u.id = :id")
    Set<Entrenamiento> findEntrenamientoByUsuarioId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Entrenamiento re WHERE re.id = :id AND re.idEntrenamiento = :idEntrenamiento")
    void deleteEntrenamientoByUsuarioId(@Param("id") Integer id, @Param("idEntrenamiento") Integer idEntrenamiento);
}
