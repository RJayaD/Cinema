/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author MALAGANA
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "pelicula_salacine")
public class PeliculaSala {
    @Id
    @Column(name="id_pelicula_sala")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idPeliculaSala;
    @Column(name="fecha_publicacion")
    private Date fechaPublicacion;
    @Column(name="fecha_fin")
    private Date fechaFin;
    
    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula")
    private Pelicula pelicula;
    
    @ManyToOne
    @JoinColumn(name = "id_sala_cine", referencedColumnName = "id_sala")
    private SalaCine salaCine;
}
