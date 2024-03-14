/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cinema.service.Interface;

import com.cinema.entity.Pelicula;
import com.cinema.repository.PeliculaDto;
import java.util.List;

/**
 *
 * @author MALAGANA
 */
public interface IPelicula {
    
    List<Pelicula> listAll();
    
    Pelicula save(PeliculaDto peliculaDto);
    
    Pelicula findById(Integer Id);
    
    void delete(Pelicula pelicula);
    
    boolean existsById(Integer id);
    
    
}
