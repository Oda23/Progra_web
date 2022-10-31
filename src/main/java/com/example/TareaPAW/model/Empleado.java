/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TareaPAW.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Odalis
 */
@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empelado")
    private Integer cod_empleado;
    @NotBlank
    private String nombre_empleado;
    @NotBlank
    private String horario_empleado;
    @NotBlank
    private String correo_empleado;
    @NotBlank
    private String celular_empleado;
    @NotBlank
    private String link_empleado;
    @NotBlank
    private String rutafoto;
    
    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "empleado_sucursal", joinColumns = @JoinColumn(name= "id_empleado" ),inverseJoinColumns = @JoinColumn(name = "id_sucursal"))
    private List<Sucursal>Sucursal;
    
    @Transient
    private MultipartFile foto;

    public Empleado() {
    }

    public Empleado(Integer cod_empleado, String nombre_empleado, String horario_empleado, String correo_empleado, String celular_empleado, String link_empleado, String rutafoto, List<Sucursal> Sucursal, MultipartFile foto) {
        this.cod_empleado = cod_empleado;
        this.nombre_empleado = nombre_empleado;
        this.horario_empleado = horario_empleado;
        this.correo_empleado = correo_empleado;
        this.celular_empleado = celular_empleado;
        this.link_empleado = link_empleado;
        this.rutafoto = rutafoto;
        this.Sucursal = Sucursal;
        this.foto = foto;
    }

   

    public String getRutafoto() {
        return rutafoto;
    }

    public void setRutafoto(String rutafoto) {
        this.rutafoto = rutafoto;
    }

    public Empleado(String nombre_empleado, String horario_empleado, String correo_empleado, String celular_empleado, String link_empleado, String rutafoto, List<Sucursal> Sucursal, MultipartFile foto) {
        this.nombre_empleado = nombre_empleado;
        this.horario_empleado = horario_empleado;
        this.correo_empleado = correo_empleado;
        this.celular_empleado = celular_empleado;
        this.link_empleado = link_empleado;
        this.rutafoto = rutafoto;
        this.Sucursal = Sucursal;
        this.foto = foto;
    }

   

    public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getHorario_empleado() {
        return horario_empleado;
    }

    public void setHorario_empleado(String horario_empleado) {
        this.horario_empleado = horario_empleado;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }

    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public String getCelular_empleado() {
        return celular_empleado;
    }

    public void setCelular_empleado(String celular_empleado) {
        this.celular_empleado = celular_empleado;
    }

    public String getLink_empleado() {
        return link_empleado;
    }

    public void setLink_empleado(String link_empleado) {
        this.link_empleado = link_empleado;
    }

    public List<Sucursal> getSucursal() {
        return Sucursal;
    }

    public void setSucursal(List<Sucursal> Sucursal) {
        this.Sucursal = Sucursal;
    }

    public MultipartFile getFoto() {
        return foto;
    }

    public void setFoto(MultipartFile foto) {
        this.foto = foto;
    }

    


}
