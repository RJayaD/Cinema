/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.controller;

import com.cinema.entity.Pelicula;
import com.cinema.entity.PeliculaSala;
import com.cinema.service.ConsultaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MALAGANA
 */
@RestController
@RequestMapping("api/v1/consultas")
public class ConsultaController {
    
    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/cinemaSearch")
    public List<PeliculaSala> cinemaSearch(@RequestParam String nombrePelicula, @RequestParam Integer cineId) {
        return consultaService.cinemaSearch(nombrePelicula, cineId);
    }

    @GetMapping("/cinemaByDate")
    public List<PeliculaSala> countCinemaByDate(@RequestParam Date fechaPublicacion) {
        return consultaService.cinemaDate(fechaPublicacion);
    }

    @GetMapping("/stateCinema")
    public String stateCinema(@RequestParam String nombreSala) {
        return consultaService.stateCinema(nombreSala);
    }
}
