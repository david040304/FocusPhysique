package com.springboot.focusphysique.backend.Repositorio;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;

import jakarta.transaction.Transactional;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u.Entrenamiento FROM Usuario u WHERE u.id = :id")
    Set<Entrenamiento> findEntrenamientoByUsuarioId(@Param("id") Integer id);

    @Query("SELECT u.Rutina_Entrenamiento FROM Usuario u WHERE u.id = :id")
    Set<Rutina_Entrenamiento> findRutinaByUsuarioId(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(
        value = "DELETE FROM regsitro_entrenamiento re WHERE re.id = :id AND re.id_Entrenamiento = :idEntrenamiento",
    nativeQuery = true
    )
    void deleteEntrenamientoByUsuarioId(@Param("id") Integer id, @Param("idEntrenamiento") Integer idEntrenamiento);

    @Modifying
    @Transactional
    @Query(
        value = "DELETE FROM regsitro_rutina re WHERE rr.id = :id AND rr.id_Rutina = :idRutina",
    nativeQuery = true
    )
    void deleteRutinaByUsuarioId(@Param("id") Integer id, @Param("idRutina") Integer idRutina);
}
