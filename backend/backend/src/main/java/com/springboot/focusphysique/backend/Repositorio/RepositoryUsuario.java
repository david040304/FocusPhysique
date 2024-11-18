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

    // Llamada al procedimiento almacenado para eliminar un usuario
    @Procedure(name = "Delete_Usuario")
    void eliminarUsuario(@Param("P_Id_usuario") Integer id_usuario);

    @Procedure(name = "Update_Usuario")
    void updateUsuario(
        @Param("P_Id_usuario") String id_Usuario,
        @Param("P_P_Nombre") String p_Nombre,
        @Param("P_S_Nombre") String s_Nombre,
        @Param("P_P_Apellido") String p_Apellido,
        @Param("P_S_Apellido") String s_Apellido,
        @Param("P_Edad") Integer edad,
        @Param("P_Telefono") String telefono,
        @Param("P_Genero") Character genero,
        @Param("P_Altura_Inicio") Double altura_Inicio,
        @Param("P_Peso_Inicio") Double peso_Inicio,
        @Param("P_Id_cuenta") Integer id_Cuenta
    );
}
