package com.springboot.focusphysique.backend.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.springboot.focusphysique.backend.Entidades.Registro_Rutina;


public interface RepositoryRegistro_Rutina extends JpaRepository<Registro_Rutina, Integer>{
    // Procedimiento para insertar un registro
    @Procedure(name = "Insert_Registro_Rutina")
    void insertRegistroRutina(
        @Param("P_Id_usuario") Integer id_Usuario,
        @Param("P_Id_rutina") Integer id_Rutina
    );

    // Procedimiento para eliminar un registro
    @Procedure(name = "Delete_Registro_Rutina")
    void eliminarRegistroRutina(
        @Param("P_Id_Reg_Rutina") Integer id_Reg_Rutina
    );

    // Procedimiento para actualizar un registro
    @Procedure(name = "Update_Registro_Rutina")
    void updateRegistroRutina(
        @Param("P_Id_Reg_Rutina") Integer id_Reg_Rutina,
        @Param("P_Id_usuario") Integer id_Usuario,
        @Param("P_Id_rutina") Integer id_Rutina
    );
}
