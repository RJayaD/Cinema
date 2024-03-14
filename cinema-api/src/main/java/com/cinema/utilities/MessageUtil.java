/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.utilities;

import lombok.Getter;
/**
 *
 * @author MALAGANA
 */


@Getter
public enum MessageUtil {
    
        OK("Proceso exitoso.", 200),
	CREATED("Creación exitosa.", 201), 
	UPDATED("Actualización exitosa.", 200), 
	DELETED("Eliminación exitosa.", 200), 
	
	CHECKREQUEST("Esta mandando un dato erróneo, revisa y vuelva a intentar.", 400),
	BADREQUEST("Hubo un error en su petición.", 400),
	
	NOTFOUND("No existen registros.", 404),
	
	INTERNALERROR("Error en el servidor.", 500),
	
	CONFLICT("Hubo un conflicto en su petición.", 409),
	MODULOEXIST("Ya existe un registro con estos datos.", 409),
	
	INGRESENOMBRE("Por favor ingrese su nombre.", 400),
	
	JSONSCHEMA("No se pudo leer el formato JsonSchema.", 409),
	;
	
	private String key;
	private int code;
	
	private MessageUtil(String key, int code) {
		this.key = key;
		this.code = code;
	}
}
