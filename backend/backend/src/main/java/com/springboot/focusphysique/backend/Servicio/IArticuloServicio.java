package com.springboot.focusphysique.backend.Servicio;


import java.util.List;

import com.springboot.focusphysique.backend.Dto.Articulo_InfoDto;


public interface IArticuloServicio {
    Articulo_InfoDto crearArticuloInformativo( Articulo_InfoDto datosArticulo);
    List<Articulo_InfoDto> obtenerArticulos();
    List<Articulo_InfoDto> obtenerArticulosPorAdministrador(Integer id);
    Articulo_InfoDto updateArticulo(Integer id, Articulo_InfoDto datosArticulo);
    void eliminarArticuloInformativo(Integer id); 
}
