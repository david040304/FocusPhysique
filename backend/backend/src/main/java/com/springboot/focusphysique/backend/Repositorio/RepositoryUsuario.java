package com.springboot.focusphysique.backend.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.focusphysique.backend.Entidades.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {

}
