package com.springboot.focusphysique.backend.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.focusphysique.backend.Entidades.Cuenta;

public interface RepositoryCuenta  extends JpaRepository<Cuenta,Integer>{

    //buscar por ID
    List<Cuenta> findAllById(Integer Id);


}
