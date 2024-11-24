package com.springboot.focusphysique.backend.Servicio;


import java.util.List;

import com.springboot.focusphysique.backend.Entidades.Articulos_Info;

public interface IArticuloServicio {
    Articulos_Info crearArticuloInformativo(Integer id, Articulos_Info datosArticulo);

    List<Articulos_Info> obtenerArticulos();

    List<Articulos_Info> obtenerArticulosPorAdministrador(Integer id);

    Articulos_Info actualizarArticuloInformativo(Integer id, Articulos_Info datosArticulo);

    void eliminarArticuloInformativo(Integer id); 
}
