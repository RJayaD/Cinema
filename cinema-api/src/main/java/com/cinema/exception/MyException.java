/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cinema.exception;

import java.util.ArrayList;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author MALAGANA
 */
@Getter
public class MyException extends Exception {
   	
	private ArrayList<String> messages = new ArrayList<>();
	private Integer code;
	private HttpStatus code2;
	
	public MyException(ArrayList<String> messages, Integer code) {
		super();
		this.messages = messages;
		this.code = code;
	}
	
	public MyException(String messages, Integer code) {
		super();
		this.messages.add(messages);
		this.code = code;
	}
	
	public MyException(ArrayList<String> messages, HttpStatus code2) {
		super();
		this.messages = messages;
		this.code2 = code2;
	}
	
	public MyException(String messages, HttpStatus code2) {
		super();
		this.messages.add(messages);
		this.code2 = code2;
	}
}
