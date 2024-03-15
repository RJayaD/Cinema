/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.service;

import com.cinema.service.Interface.IPelicula;
import com.cinema.entity.Pelicula;
import com.cinema.exception.MyException;
import com.cinema.exception.ResourceNotFoundException;
import com.cinema.helper.SchemaHelper;
import com.cinema.repository.dao.PeliculaDao;
import com.cinema.repository.PeliculaDto;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MALAGANA
 */
@Service
public class PeliculaService implements IPelicula {


    @Autowired
    private PeliculaDao _peliculaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Pelicula> listAll() {
        return (List) _peliculaDao.findAll();
    }

    @Transactional
    @Override
    public PeliculaDto save(PeliculaDto peliculaDto) {
        
        Pelicula pelicula=null;
        try {
             pelicula= _peliculaDao.save(Pelicula.builder()
                    .idPelicula(peliculaDto.getIdPelicula())
                    .nombre(peliculaDto.getNombre())
                    .duracion(peliculaDto.getDuracion())
                    .build());
              peliculaDto.setIdPelicula(pelicula.getIdPelicula());
            return peliculaDto;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public PeliculaDto findById(Integer Id) {
        Optional<Pelicula> Optional = _peliculaDao.findById(Id);
        if (Optional.isPresent()) {
            Pelicula pelicula = Optional.get();
            return PeliculaDto.builder()
                    .idPelicula(pelicula.getIdPelicula())
                    .nombre(pelicula.getNombre())
                    .duracion(pelicula.getDuracion())
                    .build();
        }
        throw new ResourceNotFoundException("Pelicula not found with id: " + Id);
    }

    @Transactional
    @Override
    public void delete(PeliculaDto peliculaDto) {
        _peliculaDao.delete(Pelicula.builder()
                    .idPelicula(peliculaDto.getIdPelicula())
                    .nombre(peliculaDto.getNombre())
                    .duracion(peliculaDto.getDuracion())
                    .build());
    }

    @Override
    public boolean existsById(Integer id) {
        return _peliculaDao.existsById(id);
    }

}
