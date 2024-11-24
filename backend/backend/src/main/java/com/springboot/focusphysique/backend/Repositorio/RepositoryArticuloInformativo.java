package com.springboot.focusphysique.backend.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.focusphysique.backend.Entidades.Articulos_Info;

public interface RepositoryArticuloInformativo extends JpaRepository<Articulos_Info, Integer>{
    List<Articulos_Info> findByAdministradorId(Integer id);
}
