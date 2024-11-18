package com.springboot.focusphysique.backend.Repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Cuenta;

public interface RepositoryCuenta  extends JpaRepository<Cuenta,Integer>{

  
    //Ejecutar procedimiento almacenado insertar
    @Procedure(name="Insert_Cuenta")
    void insertCuenta(@Param("p_usuario" ) String usuario, @Param("p_contraseña") String contraseña);

    //procedimiento eliminar cuenta
    @Procedure(name="Delete_Cuenta")
    void deleteCuenta(@Param("p_id_cuenta") Integer id);
    
    //procedimiento actualizar cuenta
    @Procedure(name="Update_Cuenta")
    void updateCuenta(@Param("p_id_cuenta") Integer id, @Param("p_usuario") String usuario, @Param("p_contraseña") String contraseña);



}
