/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.service;

import com.cinema.service.Interface.IPelicula;
import com.cinema.entity.Pelicula;
import com.cinema.repository.dao.PeliculaDao;
import com.cinema.repository.PeliculaDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MALAGANA
 */
@Service
public class PeliculaService implements IPelicula{

    @Autowired
    private PeliculaDao _peliculaDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<Pelicula> listAll() {
         return (List) _peliculaDao.findAll();
    }
    
    @Transactional
    @Override
    public Pelicula save(PeliculaDto peliculaDto) {
        Pelicula _pelicula = Pelicula.builder()
                .idPelicula(peliculaDto.getIdPelicula())
                .nombre(peliculaDto.getNombre())
                .duracion(peliculaDto.getDuracion())
                .build();
        return _peliculaDao.save(_pelicula);
    }

    @Transactional(readOnly = true)
    @Override
    public Pelicula findById(Integer Id) {
        return _peliculaDao.findById(Id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Pelicula pelicula) {
        _peliculaDao.delete(pelicula);
    }
    
     @Override
    public boolean existsById(Integer id) {
        return _peliculaDao.existsById(id);
    }
    
}
