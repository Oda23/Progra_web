/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TareaPAW.exceptiones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Odalis
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1L;
    public FileNotFoundException(String mensaje){
        super(mensaje);
    }
    
    public FileNotFoundException(String mensaje,Throwable exception){
        super(mensaje,exception);
    }
}
