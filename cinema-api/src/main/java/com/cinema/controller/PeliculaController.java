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
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .object(null)
                            .build(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(getList)
                        .build(), HttpStatus.OK);
    }

    
    @PostMapping("movie")
    public ResponseEntity<?> create(@RequestBody PeliculaDto peliculaDto) {

        Pelicula _peliculaSave = null;
        try {
            _peliculaSave = _peliculaService.save(peliculaDto);
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("Guardado exitosamente")
                            .object(PeliculaDto.builder()
                                    .idPelicula(_peliculaSave.getIdPelicula())
                                    .nombre(_peliculaSave.getNombre())
                                    .duracion(_peliculaSave.getDuracion())
                                    .build())
                            .build(),
                    HttpStatus.CREATED);

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    
    
    
    @DeleteMapping("movie/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Pelicula peliculaDelete = _peliculaService.findById(id);
            _peliculaService.delete(peliculaDelete);
            return new ResponseEntity<>(peliculaDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }
    
    @GetMapping("movie/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Pelicula _cliente = _peliculaService.findById(id);
        if (_cliente == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("El registro no existe")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("")
                        .object(PeliculaDto.builder()
                                    .idPelicula(_cliente.getIdPelicula())
                                    .nombre(_cliente.getNombre())
                                    .duracion(_cliente.getDuracion())
                                    .build())
                        .build(), HttpStatus.OK);
    }
    
    
}
