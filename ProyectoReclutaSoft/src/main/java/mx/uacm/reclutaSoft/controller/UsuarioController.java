package mx.uacm.reclutaSoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.UsuarioService;

@Controller
@RequestMapping("/usuarioController")
public class UsuarioController {
	private final Logger log = LogManager.getLogger(UsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(Map <String, Object> model, Usuario usuario) {
		log.debug("Entrando al metodo UsuarioController.registrarUsuario");
		
		String nombre = usuario.getNombre();
		String apellidoPaterno = usuario.getApellidoPaterno();
		String apellidoMaterno = usuario.getApellidoMaterno();
		String correo = usuario.getCorreo();
		String contrasenia = usuario.getContrasenia();
		String telefono = usuario.getTelefono();
		List<Habilidad> habilidades = usuario.getHabilidades();
		int edad = usuario.getEdad();
		String web = usuario.getWeb();
		String titulo = usuario.getTitulo();
		
		Usuario usuarioRegresado = null;
		
		try {
			usuarioRegresado = usuarioService.alta(nombre, apellidoPaterno,
					                               apellidoMaterno, correo, 
					                               contrasenia, telefono,
					                               habilidades, edad, web,
					                               titulo);
		} catch (AppExcepcion e) {
//			String excepcion = e.getMessage();
			switch (e.getMessage()) {
			case Error.MAL_NOMBRE:
				model.put("error", Error.MAL_NOMBRE);
				return "redirect:/error";
				
			case Error.MAL_AP_PATERNO:
				model.put("error", Error.MAL_AP_PATERNO);
				return "redirect:/error";
				
			case Error.MAL_AP_MATERNO:
				model.put("error", Error.MAL_AP_MATERNO);
				return "redirect:/error";
			
			case Error.MAL_CORREO:
				model.put("error", Error.MAL_CORREO);
				return "redirect:/error";
				
			case Error.MAL_CONTRASENIA:
				model.put("error", Error.MAL_CONTRASENIA);
				return "redirect:/error";
				
			case Error.MAL_TELEFONO:
				model.put("error", Error.MAL_TELEFONO);
				return "redirect:/error";
				
			case Error.MAL_HABILIDADES:
				model.put("error", Error.MAL_HABILIDADES);
				return "redirect:/error";
			
			case Error.MAL_EDAD:
				model.put("error", Error.MAL_EDAD);
				return "redirect:/error";
				
			case Error.MAL_WEB:
				model.put("error", Error.MAL_AP_PATERNO);
				return "redirect:/error";	
			
			case Error.MAL_GR_ACADEMICO:
				model.put("error", Error.MAL_GR_ACADEMICO);
				return "redirect:/error";
				
			default:
				break;
			}
		}
		model.put("enviado", usuarioRegresado);
		return "redirect:/perfil";
	}
	
}
