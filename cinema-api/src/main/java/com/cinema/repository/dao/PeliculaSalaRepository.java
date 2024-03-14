/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.repository.dao;

import com.cinema.entity.Pelicula;
import com.cinema.entity.PeliculaSala;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author MALAGANA
 */
@Repository
public interface PeliculaSalaRepository extends JpaRepository<PeliculaSala, Integer> {
    
    List<PeliculaSala> findByPeliculaNombreAndSalaCineIdSala(String nombrePelicula, Integer idSalaCine);

    List<PeliculaSala> findByFechaPublicacion(Date fechaPublicacion);

    @Query("SELECT COUNT(pc) FROM PeliculaSala pc WHERE pc.salaCine.nombre = :nombre")
    int countPeliculasPorSala(@Param("nombre") String nombreSala);
}
