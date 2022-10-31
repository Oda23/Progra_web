/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.TareaPAW.servicio;

import java.nio.file.Path;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Odalis
 */
public interface AlmacenServicio {
    
    public void iniciarAlmacenDEArchivos();
    
    public String almacenarArchivo(MultipartFile archivo);
    
    public Path cargarArchivos(String nombreArchivo); 
    public Resource cargarComoRecurso(String nombreArchivo);
    public void eliminarArchivo(String nombreArchivo);
}
