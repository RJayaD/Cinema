/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.service;

import com.cinema.entity.Pelicula;
import com.cinema.entity.PeliculaSala;
import com.cinema.repository.dao.PeliculaSalaRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MALAGANA
 */
@Service
public class ConsultaService {
    
    @Autowired
    private PeliculaSalaRepository _consultaRepository;
    
   public List<PeliculaSala> cinemaSearch(String nombrePelicula, Integer idSala) {
        return _consultaRepository.findByPeliculaNombreAndSalaCineIdSala(nombrePelicula, idSala);
    }

    public List<PeliculaSala> cinemaDate(Date fechaPublicacion) {
        return (List) _consultaRepository.findByFechaPublicacion(fechaPublicacion);
    }

    public String stateCinema(String nombreSala) {
        int cantidadPeliculas = _consultaRepository.countPeliculasPorSala(nombreSala);
        if (cantidadPeliculas < 3) {
            return "Sala casi Vacía";
        } else if (cantidadPeliculas >= 3 && cantidadPeliculas <= 5) {
            return "Sala casi Llena";
        } else {
            return "Sala Llena";
        }
    }
}
