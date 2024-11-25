package com.springboot.focusphysique.backend.Servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.focusphysique.backend.Entidades.Administrador;
import com.springboot.focusphysique.backend.Entidades.Articulos_Info;
import com.springboot.focusphysique.backend.Repositorio.RepositoryArticuloInformativo;
import com.springboot.focusphysique.backend.Servicio.IAdminServicio;
import com.springboot.focusphysique.backend.Servicio.IArticuloServicio;

@Service
public class ArticuloServiceImpl implements IArticuloServicio{
    @Autowired
    private RepositoryArticuloInformativo repo;

    @Autowired
    private IAdminServicio adminServicio;

    @Override
    public Articulos_Info crearArticuloInformativo(Integer id, Articulos_Info datosArticulo) {
        // Verificar si el administrador existe
        Administrador admin = adminServicio.obtenerAdminPorId(id)
                .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));

        // Asociar el artículo al administrador y guardar
        datosArticulo.setAdministrador(admin);
        return repo.save(datosArticulo);
    }

    @Override
    public List<Articulos_Info> obtenerArticulos() {
        return repo.findAll(); // Retorna todos los artículos informativos
    }

    @Override
    public List<Articulos_Info> obtenerArticulosPorAdministrador(Integer id) {
        return repo.findByAdministradorId(id);  // Este método ya devuelve una lista de artículos asociados al administrador
    }

    @Override
    public Articulos_Info actualizarArticuloInformativo(Integer id, Articulos_Info datosArticulo) {
        Articulos_Info articulo = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Artículo no encontrado"));

        articulo.setTitulo(datosArticulo.getTitulo());
        articulo.setContenido(datosArticulo.getContenido());
        return repo.save(articulo);
    }

    @Override
    public void eliminarArticuloInformativo(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Artículo no encontrado");
        }
        repo.deleteById(id);
    }
}
