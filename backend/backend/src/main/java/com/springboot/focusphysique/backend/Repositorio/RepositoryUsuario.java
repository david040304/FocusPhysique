package com.springboot.focusphysique.backend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
    
    //Ejecutar procedimiento almacenado
    @Procedure(name="Insert_Usuario")
    void insertUsuario(
        @Param("P_P_Nombre" ) String P_Nombre, 
        @Param("P_S_Nombre") String S_Nombre,
        @Param("P_P_Apellido" ) String P_Apellido,
        @Param("P_S_Apellido" ) String S_Apellido,
        @Param("P_Edad" ) Integer Edad,
        @Param("P_Telefono" ) String Telefono,
        @Param("P_Genero" ) Character Genero,
        @Param("P_Altura_Inicio" ) Double Altura_Inicio,
        @Param("P_Peso_Inicio" ) Double Peso_Inicio,
        @Param("P_Id_cuenta" ) Integer Id_cuenta
        );

}
