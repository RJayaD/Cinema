/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cinema.repository.dao;

import com.cinema.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author MALAGANA
 */

public interface PeliculaDao extends JpaRepository<Pelicula, Integer>{
    
}
