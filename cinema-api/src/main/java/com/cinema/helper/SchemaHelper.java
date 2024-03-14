/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.helper;


import com.cinema.exception.MyException;
import static com.cinema.utilities.MessageUtil.JSONSCHEMA;
import static com.cinema.utilities.MessageUtil.CHECKREQUEST;
import static com.cinema.utilities.MessageUtil.BADREQUEST;
import static com.cinema.utilities.MessageUtil.INTERNALERROR;


import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;


/**
 *
 * @author MALAGANA
 */
@Component
public class SchemaHelper {
    
    private ArrayList<String> errorMessage;
    
    private Schema readJsonSchema(String path) throws MyException {
		try {
			JSONObject object = new JSONObject(new JSONTokener(SchemaHelper.class.getResourceAsStream(path)));
			return SchemaLoader.load(object);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(JSONSCHEMA.getKey(), JSONSCHEMA.getCode());
		}

	}

	public <T> void validateJsonSchmea(String ruta, T entidad) throws MyException {
		try {
			Schema schema = this.readJsonSchema(ruta);
			String json = new ObjectMapper().writeValueAsString(entidad);
			schema.validate(new JSONObject(json));

		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			this.errorMessage.add(CHECKREQUEST.getKey());
			if (e.getCausingExceptions().isEmpty()) {
				for (ValidationException ee : e.getCausingExceptions()) {
					this.errorMessage.add(ee.getMessage());
					System.out.println(ee.toString());
				}
			} else {
				System.out.println(e.toString());
				this.errorMessage.add(e.toString());
			}
			throw new MyException(errorMessage, CHECKREQUEST.getCode());
		} catch (MyException e) {
			System.out.println(e.getMessage());
			this.errorMessage.add(BADREQUEST.getKey());			
			throw new MyException(e.getMessage(), e.getCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new MyException(INTERNALERROR.getKey(), INTERNALERROR.getCode());
		}

	}
}
