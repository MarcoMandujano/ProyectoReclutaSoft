package mx.uacm.reclutaSoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.ProyectoService;
import mx.uacm.reclutaSoft.service.UsuarioService;


@Controller
@RequestMapping("/registrarProyecto")
public class proyectoController {
	
	
private final Logger log = LogManager.getLogger(proyectoController.class);
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HttpSession httpSession; 
	
	
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
	
	
	@GetMapping("/regProyecto")
	public String regProyecto(Map <String, Object> model) {
		

		
	log.debug("Entrando al metodo ProyectoController.obtenerUsuarios********************************************************");
	List<Usuario> usuarios = new ArrayList<Usuario>();
	try {
		usuarios = usuarioService.findUsuarios();
		
		model.put("usuarios", usuarios);
	} catch (AppExcepcion e) {
		model.put("error", e.getMessage());
		return "redirect:/error";
	}
	log.debug("return en proyectoController********************************************************");
		return "registrarProyecto";
		
	}
	
	@GetMapping("/registrar")
	public String registrar(Map <String, Object> model, @RequestParam("pagina") String pagina) {
		

		
	log.debug("Entrando al metodo ProyectoController.obtenerUsuarios********************************************************");
	List<Usuario> usuarios = new ArrayList<Usuario>();
//	try {
////		usuarios = usuarioService.findUsuarios();
//		
////		model.put("usuarios", usuarios);
//	} catch (AppExcepcion e) {
//		model.put("error", e.getMessage());
//		return "redirect:/error";
//	}
	
	model.put("current", pagina);
	String current = pagina;
	
	

	log.debug("return en proyectoController********************************************************");
		return "action";
		
	}
	

}
