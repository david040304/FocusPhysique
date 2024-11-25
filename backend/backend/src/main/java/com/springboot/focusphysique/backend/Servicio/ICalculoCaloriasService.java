package com.springboot.focusphysique.backend.Servicio;

public interface ICalculoCaloriasService {
    Double calcularCalorias(Integer id, Integer idEntrenamiento) throws IllegalArgumentException; 

}
