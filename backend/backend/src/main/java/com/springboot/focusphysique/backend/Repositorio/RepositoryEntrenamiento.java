package com.springboot.focusphysique.backend.Repositorio;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Sugerencia;




public interface RepositoryEntrenamiento extends JpaRepository<Entrenamiento, Integer>{
    @Query("SELECT e.sugerencias FROM Entrenamiento e WHERE e.idEntrenamiento = :idEntrenamiento")
    Set<Sugerencia> findSugerenciasByEntrenamientoId(@Param("idEntrenamiento") Integer idEntrenamiento);

    @Query("SELECT e FROM Entrenamiento e WHERE e.tipo_de_Entrenamiento.nombreTipo = :nombreTipo")
    List<Entrenamiento> findByTipoDeEntrenamientoNombre(@Param("nombreTipo") String nombreTipo);

    List<Entrenamiento> findByGenero(Character genero);
    List<Entrenamiento> findByNivelDificultad(String nivelDificultad);
    List<Entrenamiento> findByGrupoMuscular(String grupoMuscular);
    
    
}
