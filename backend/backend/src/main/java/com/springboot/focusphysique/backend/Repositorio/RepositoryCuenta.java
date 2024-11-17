package com.springboot.focusphysique.backend.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Cuenta;

public interface RepositoryCuenta  extends JpaRepository<Cuenta,Integer>{

    //buscar por ID
    //List<Cuenta> findAllById(Integer Id);

    //Ejecutar procedimiento almacenado
    @Procedure(name="Insert_Cuenta")
    void insertCuenta(@Param("p_usuario" ) String usuario, @Param("p_contraseña") String contraseña);


}
