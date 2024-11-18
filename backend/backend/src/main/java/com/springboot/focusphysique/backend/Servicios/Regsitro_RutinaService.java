package com.springboot.focusphysique.backend.Servicios;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.focusphysique.backend.Repositorio.RepositoryRegistro_Rutina;

public class Regsitro_RutinaService {
    @Autowired
    private RepositoryRegistro_Rutina repositoryRegistroRutina;

    public void insertarRegistroRutina(
        Integer id_Usuario,
        Integer id_Rutina
    ) {
        repositoryRegistroRutina.insertRegistroRutina(id_Usuario, id_Rutina);
    }

    public void eliminarRegistroRutina(Integer id_Reg_Rutina) {
        repositoryRegistroRutina.eliminarRegistroRutina(id_Reg_Rutina);  // Aquí ya pasas el idRegRutina directamente
    }

    // UPDATE
    public void actualizarRegistroRutina(
        Integer id_Reg_Rutina,
        Integer id_Usuario,
        Integer id_Rutina
    ) {
        repositoryRegistroRutina.updateRegistroRutina(id_Reg_Rutina, id_Usuario, id_Rutina);
    }
}
