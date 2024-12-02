package com.springboot.focusphysique.backend.mapper;

import java.util.HashSet;
import java.util.Set;

import com.springboot.focusphysique.backend.Dto.UsuarioDto;
import com.springboot.focusphysique.backend.Entidades.Cuenta;
import com.springboot.focusphysique.backend.Entidades.Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Rutina_Entrenamiento;
import com.springboot.focusphysique.backend.Entidades.Usuario;

public class UsuarioMapper {
    public static UsuarioDto mapToUsuarioDto(Usuario usuario){
        return new UsuarioDto(
            usuario.getId(),
            usuario.getP_Nombre(),
            usuario.getS_Nombre(),
            usuario.getP_Apellido(),
            usuario.getS_Apellido(),
            usuario.getEdad(),
            usuario.getTelefono(),
            usuario.getGenero(),
            usuario.getAltura_Inicio(),
            usuario.getPeso_Inicio()
        );
    }

    // Mapea el DTO UsuarioDto a la entidad Usuario
    public static Usuario mapToUsuario(UsuarioDto usuarioDto) {
        // Crear la cuenta (puedes inicializarla como null si no se tiene en el DTO)
        Cuenta cuenta = null; // Si tienes un ID de cuenta, puedes buscarla y asignarla aquí

        // Inicializa los entrenamientos y rutinas (si es necesario pasarlos desde el DTO, puedes agregar ese mapeo)
        Set<Entrenamiento> entrenamientos = new HashSet<>();
        Set<Rutina_Entrenamiento> rutinas = new HashSet<>();

        // Creación de la entidad Usuario con los datos del DTO
        return new Usuario(
            usuarioDto.getGenero(),
            usuarioDto.getAltura_Inicio(),
            usuarioDto.getPeso_Inicio(),
            cuenta, // Si no tienes la cuenta en el DTO, pasa null
            entrenamientos, // Si tienes entrenamientos, puedes pasarlos aquí
            rutinas // Lo mismo para rutinas
        );
    }
}
