/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TareaPAW.servicio;

import com.example.TareaPAW.exceptiones.AlmacenException;
import com.example.TareaPAW.exceptiones.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Odalis
 */
@Service
public class AlmacenServicioImpl implements AlmacenServicio {

    @Value("${storage.location}")
    private String storageLocation;

    @PostConstruct
    @Override
    public void iniciarAlmacenDEArchivos() {
        try {
            Files.createDirectories(Paths.get(storageLocation));
        } catch (IOException excepcion) {
            throw new AlmacenException("Error al inicializar la ubicacion en el almacen de archivos");
        }
    }

    @Override
    public String almacenarArchivo(MultipartFile archivo) {
        String nombreArchivo = archivo.getOriginalFilename();
        if (archivo.isEmpty()) {
            throw new AlmacenException("No se puede almacenar un archivo vacio");
        }
        try {
            InputStream inputStream = archivo.getInputStream();
            Files.copy(inputStream, Paths.get(storageLocation).resolve(nombreArchivo), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException excepcion) {
            throw new AlmacenException("Error al almacenar el archivo" + nombreArchivo, excepcion);
        }
        return nombreArchivo;
    }

    @Override
    public Path cargarArchivos(String nombreArchivo) {
        return Paths.get(storageLocation).resolve(nombreArchivo);
    }

    @Override
    public Resource cargarComoRecurso(String nombreArchivo) {
        try {
            Path archivo = cargarArchivos(nombreArchivo);
            Resource recurso = new UrlResource(archivo.toUri());
            if (recurso.exists() || recurso.isReadable()) {
                return recurso;
            } else {
                throw new FileNotFoundException("No se pudo encontrar el archivo " + nombreArchivo);
            }
        } catch (MalformedURLException excepcion) {
            throw new FileNotFoundException("No se pudo encontrar el archivo " + nombreArchivo, excepcion);
        }
    }

    @Override
    public void eliminarArchivo(String nombreArchivo) {
        Path archivo = cargarArchivos(nombreArchivo);
        try {
            FileSystemUtils.deleteRecursively(archivo);
        } catch (Exception excepcion) {
            System.out.println(excepcion);
        }
    }

}
