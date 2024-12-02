package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Dto.Articulo_InfoDto;
import com.springboot.focusphysique.backend.Entidades.Administrador;
import com.springboot.focusphysique.backend.Entidades.Articulos_Info;
import com.springboot.focusphysique.backend.Repositorio.RepositoryArticuloInformativo;
import com.springboot.focusphysique.backend.Servicio.IAdminServicio;
import com.springboot.focusphysique.backend.Servicio.IArticuloServicio;
import com.springboot.focusphysique.backend.exeption.ResourceNotFoundExceptio;
import com.springboot.focusphysique.backend.mapper.Articulo_InfoMapper;
import com.springboot.focusphysique.backend.mapper.SugerenciaMapper;

@Service
public class ArticuloServiceImpl implements IArticuloServicio{
    @Autowired
    private RepositoryArticuloInformativo repo;

    @Autowired
    private IAdminServicio adminServicio;

    @Override
    public Articulo_InfoDto crearArticuloInformativo( Articulo_InfoDto Articulo_InfoDto) {
        Articulos_Info articulo = Articulo_InfoMapper.mapArticulo_Info(Articulo_InfoDto);
        Articulos_Info savedArticulos_Info = repo.save(articulo);
        return Articulo_InfoMapper.mapArticulo_InfoDto(savedArticulos_Info);

 
    }

    @Override
    public List<Articulo_InfoDto> obtenerArticulos() {
        List<Articulos_Info> articulos = repo.findAll();
        return articulos.stream().map((Articulos_Info) -> Articulo_InfoMapper.mapArticulo_InfoDto(Articulos_Info))
        .collect(Collectors.toList()); // Retorna todos los artículos informativos
    }

    @Override
    public List<Articulo_InfoDto> obtenerArticulosPorAdministrador(Integer id) {
        return repo.findByAdministradorId(id);  // Este método ya devuelve una lista de artículos asociados al administrador
    }

    @Override
    public Articulo_InfoDto updateArticulo(Integer idArticulo, Articulo_InfoDto datosArticulo) {
        Articulos_Info articulo = repo.findById(idArticulo)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));

                articulo.setTitulo(datosArticulo.getTitulo());
                articulo.setContenido(datosArticulo.getContenido());
                articulo.setFechaPublicacion(datosArticulo.getFechaPublicacion());
                Articulos_Info updateArticuloObj = repo.save(articulo);
                return Articulo_InfoMapper.mapArticulo_InfoDto(updateArticuloObj);
    }

    @Override
    public void eliminarArticuloInformativo(Integer idArticulo) {
        // Validar si el artículo existe
        Articulos_Info articulo = repo.findById(idArticulo) 
            .orElseThrow(() -> new ResourceNotFoundExceptio("Sugerencia is not exists with given id: " + idArticulo) 
            );
    
        // Eliminar el artículo por ID
        repo.deleteById(idArticulo);
    }
    
}
