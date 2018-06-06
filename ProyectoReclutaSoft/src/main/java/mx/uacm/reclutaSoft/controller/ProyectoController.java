package mx.uacm.reclutaSoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.ProyectoService;

@Controller
@RequestMapping("/proyectoController")
public class ProyectoController {
	private final Logger log = LogManager.getLogger(ProyectoController.class);
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping("/obtenerProyectos")
	public String obtenerProyectos(Map <String, Object> model) {
		log.debug("Entrando a ProyectoController.obtenerProyectos");
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		try {
			proyectos = proyectoService.findPoryectos();
			model.put("proyectos", proyectos);
		} catch (AppExcepcion e) {
			model.put("error", e.getMessage());
			return "redirect:/error";
		}
		
		return "preubasMarco";
	}
	
	
}
