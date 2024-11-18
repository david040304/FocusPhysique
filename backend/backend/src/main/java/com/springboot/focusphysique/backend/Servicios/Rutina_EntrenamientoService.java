package com.springboot.focusphysique.backend.Servicios;

import java.sql.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Repositorio.RepositoryRutina_Entrenamiento;

@Service
public class Rutina_EntrenamientoService {
    @Autowired
    private RepositoryRutina_Entrenamiento RepositoryRutina_Entrenamiento;
    
    public void Insert_Rutina_Entrenamiento(
        String nombre,
        String descripcion,
        Time duracion,
        String nivel_Dificultad
    ){
        RepositoryRutina_Entrenamiento.insertRutina_Entrenamiento(
            nombre, descripcion, duracion, nivel_Dificultad
        );
    }

    public void eliminar_Rutina_Entrenamiento(Integer Id_Rutina) {
        RepositoryRutina_Entrenamiento.eliminar_Rutina_Entrenamiento(Id_Rutina);  // Aquí ya pasas el Id_usuario directamente
    }

    //UPDATE
    public void Update_Rutina_Entrenamiento(Integer id_Rutina, String nombre, String descripcion, Time duracion, String nivel_Dificultad) {
        RepositoryRutina_Entrenamiento.updateRutina(id_Rutina,nombre,descripcion,duracion,nivel_Dificultad);
    }
}
