package com.springboot.focusphysique.backend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.focusphysique.backend.Entidades.Administrador;

public interface RepositoryAdmin extends JpaRepository<Administrador, Integer>{
}
