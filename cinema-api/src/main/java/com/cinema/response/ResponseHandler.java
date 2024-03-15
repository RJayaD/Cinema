/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author MALAGANA
 */
public class ResponseHandler {
    
    public static <T> ResponseEntity<T> generateResponse(T body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }

    public static ResponseEntity<String> generateError(HttpStatus status, String message) {
        return new ResponseEntity<>(message, status);
    }
}
