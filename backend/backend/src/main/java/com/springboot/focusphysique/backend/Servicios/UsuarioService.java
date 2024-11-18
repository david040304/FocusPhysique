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
}
