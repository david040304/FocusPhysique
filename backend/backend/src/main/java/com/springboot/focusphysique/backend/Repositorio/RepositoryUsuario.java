package com.springboot.focusphysique.backend.Repositorio;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u.entrenamiento FROM Usuario u WJERE u.id = :id")
    Set<Entrenamiento> findEntrenamientoByUsuarioId(@Param("id") Integer id);
}
