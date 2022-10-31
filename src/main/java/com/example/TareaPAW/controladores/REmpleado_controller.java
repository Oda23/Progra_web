/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.TareaPAW.controladores;

import com.example.TareaPAW.model.Empleado;
import com.example.TareaPAW.model.Sucursal;
import com.example.TareaPAW.repository.EmpleadoRepositorio;
import com.example.TareaPAW.repository.SucursalRepositorio;
import com.example.TareaPAW.servicio.AlmacenServicioImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Odalis
 */
@Controller
@RequestMapping("/admin")
public class REmpleado_controller {
    @Autowired
    private EmpleadoRepositorio empleadorepositorio;
    
    @Autowired
    private SucursalRepositorio sucursalrepositorio; 
    
    @Autowired
    private AlmacenServicioImpl servicio; 
    
    @GetMapping("")
    public ModelAndView verPaginadeinicio(@PageableDefault(size = 5)Pageable pageable){
        Page<Empleado>empleado = empleadorepositorio.findAll(pageable);
        return new ModelAndView("index").addObject("empleado", empleado);
    }
    @GetMapping("/empleado/nuevo")
    public ModelAndView mostrarFormularioEmpleado(){
        List<Sucursal> sucursal = sucursalrepositorio.findAll();
        return new ModelAndView("admin/nuevo-empleado")
                .addObject("empleado",new Empleado())
                .addObject("sucursal",sucursal);
                
    }
    
    @PostMapping("/empleado/nuevo")
	public ModelAndView registrarEmpleado(@Validated Empleado empleado,BindingResult bindingResult) {
		if(empleado.getFoto().isEmpty()) {
			if(empleado.getFoto().isEmpty()) {
				bindingResult.rejectValue("foto","MultipartNotEmpty");
			}
			
			List<Sucursal> sucursal =  sucursalrepositorio.findAll();
			return new ModelAndView("admin/nuevo-empleado")
					.addObject("empleado",empleado)
					.addObject("sucursal",sucursal);
		}
		
		String RFoto = servicio.almacenarArchivo(empleado.getFoto());
		empleado.setRutafoto(RFoto);
		
		empleadorepositorio.save(empleado);
		return new ModelAndView("redirect:/admin");
	}
	
}
