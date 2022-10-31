/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.TareaPAW.repository;

import com.example.TareaPAW.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Odalis
 */
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer>{
    
}
