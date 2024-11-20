package com.springboot.focusphysique.backend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.focusphysique.backend.Entidades.Tipo_de_Entrenamiento;

public interface RepositoryTipoDeEntrenamiento extends JpaRepository<Tipo_de_Entrenamiento, Integer> {
}
