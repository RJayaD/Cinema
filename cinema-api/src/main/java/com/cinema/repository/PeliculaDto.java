/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.repository;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author MALAGANA
 */
@Data
@ToString
@Builder
public class PeliculaDto {
    
    private Integer idPelicula;
    private String nombre;
    private Integer duracion;
}
