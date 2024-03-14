/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.utilities;

import java.io.Serializable;
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
public class MensajeResponse implements Serializable {
    
    private String mensaje;
    private Object object;
}
