package com.springboot.focusphysique.backend.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.focusphysique.backend.Entidades.Administrador;

public interface RepositoryAdmin extends JpaRepository<Administrador, Integer>{
    Optional<Administrador> findById(Integer id);
}
