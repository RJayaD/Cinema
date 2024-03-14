/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.controller;

import com.cinema.service.Interface.IPelicula;
import com.cinema.entity.Pelicula;
import com.cinema.repository.PeliculaDto;
import com.cinema.utilities.MensajeResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MALAGANA
 */
@RestController
@RequestMapping("/api/v1")
public class PeliculaController {

    @Autowired(required = true)
    private IPelicula _peliculaService;

    @GetMapping("movies")
    public ResponseEntity<?> showAll() {
        List<Pelicula> getList = _peliculaService.listAll();
        return new ResponseEntity<>(getList, HttpStatus.OK);
    }

    
    @PostMapping("movie")
    public ResponseEntity<?> create(@RequestBody PeliculaDto peliculaDto) {
        return new ResponseEntity<>(_peliculaService.save(peliculaDto),HttpStatus.CREATED);
    }
    
    
    
    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
            Pelicula peliculaDelete = _peliculaService.findById(id);
            _peliculaService.delete(peliculaDelete);
            return new ResponseEntity<>(peliculaDelete, HttpStatus.NO_CONTENT);
       

    }
    
    @GetMapping("movie/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Pelicula _cliente = _peliculaService.findById(id);
        return new ResponseEntity<>(_cliente,HttpStatus.OK);
    }
    
    
}
