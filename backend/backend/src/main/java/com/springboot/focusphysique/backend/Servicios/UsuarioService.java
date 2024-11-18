package com.springboot.focusphysique.backend.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.focusphysique.backend.Repositorio.RepositoryUsuario;

@Service
public class UsuarioService {

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    public void insertarUsuario(
        String P_Nombre,
        String S_Nombre,
        String P_Apellido,
        String S_Apellido,
        Integer Edad,
        String Telefono,
        Character Genero,
        Double Altura_Inicio,
        Double Peso_Inicio,
        Integer Id_cuenta
    ) {
        repositoryUsuario.insertUsuario(
            P_Nombre, S_Nombre, P_Apellido, S_Apellido, 
            Edad, Telefono, Genero, Altura_Inicio, Peso_Inicio, Id_cuenta
        );
    }
    public void eliminarUsuario(Integer Id_Usuario) {
    repositoryUsuario.eliminarUsuario(Id_Usuario);  // Aquí ya pasas el Id_usuario directamente
    }

    //UPDATE
    public void actualizarUsuario(String id_Usuario, String p_Nombre, String s_Nombre, String p_Apellido,
        String s_Apellido, Integer edad, String telefono, Character genero,
        Double altura_Inicio, Double peso_Inicio, Integer id_Cuenta) {
            repositoryUsuario.updateUsuario(id_Usuario, p_Nombre, s_Nombre, p_Apellido, s_Apellido, edad,
            telefono, genero, altura_Inicio, peso_Inicio, id_Cuenta);
    }
}
