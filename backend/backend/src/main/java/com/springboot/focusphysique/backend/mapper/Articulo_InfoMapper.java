package com.springboot.focusphysique.backend.mapper;

import com.springboot.focusphysique.backend.Dto.Articulo_InfoDto;
import com.springboot.focusphysique.backend.Entidades.Articulos_Info;

public class Articulo_InfoMapper {

    public static Articulo_InfoDto mapArticulo_InfoDto(Articulos_Info Articulos_Info){

        return new Articulo_InfoDto(
            Articulos_Info.getIdArticulo(),
            Articulos_Info.getTitulo(),
            Articulos_Info.getContenido(),
            Articulos_Info.getFechaPublicacion()
        );
    }
    
    public static Articulos_Info mapArticulo_Info(Articulo_InfoDto articulo_InfoDto){
        return new Articulos_Info(
            articulo_InfoDto.getIdArticulo(),
            articulo_InfoDto.getTitulo(),
            articulo_InfoDto.getContenido(),
            articulo_InfoDto.getFechaPublicacion(),
            null
        );
    }

}
