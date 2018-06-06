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
	
	@Autowired
	private HttpSession httpSession; 
	
	@PostMapping("/registrarUsuario")
	public String registrarUsuario(Map <String, Object> model, Usuario usuario,
			                       @RequestParam("lenguaje") List<String>lenguajes,
			                       @RequestParam("idioma") List<String>idiomas){
		log.debug("Entrando al metodo UsuarioController.registrarUsuario");
		
		String nombre = usuario.getNombre();
		String apellidoPaterno = usuario.getApellidoPaterno();
		String apellidoMaterno = usuario.getApellidoMaterno();
		String correo = usuario.getCorreo();
		String contrasenia = usuario.getContrasenia();
		String telefono = usuario.getTelefono();
		
		List<Habilidad> habilidadesTemp = new ArrayList<Habilidad>();
		
		for (String lenguaje : lenguajes) {
			log.debug("lenguaje = " + lenguaje);
			Habilidad habilidad = new Habilidad();
			habilidad.setTipo("Lenguaje de programacion");
			habilidad.setNombre(lenguaje);
			habilidad.setPuntuacion(0);
			habilidadesTemp.add(habilidad);
		}
		
		for (String idioma : idiomas) {
			log.debug("idioma = " + idioma);
			Habilidad habilidad = new Habilidad();
			habilidad.setTipo("Idioma");
			habilidad.setNombre(idioma);
			habilidad.setPuntuacion(0);
			habilidadesTemp.add(habilidad);
		}
		usuario.setHabilidades(habilidadesTemp);
		
		List<Habilidad> habilidades = usuario.getHabilidades();
		int edad = usuario.getEdad();
		String web = usuario.getWeb();
		String titulo = usuario.getTitulo();
		
//		log.debug(titulo);
		
		Usuario usuarioRegresado = new Usuario();
		
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
				log.debug("Error MAL_NOMBRE");
				model.put("error", Error.MAL_NOMBRE);
				return "redirect:/error";
				
			case Error.MAL_AP_PATERNO:
				log.debug("Error MAL_AP_PATERNO");
				model.put("error", Error.MAL_AP_PATERNO);
				return "redirect:/error";
				
			case Error.MAL_AP_MATERNO:
				log.debug("Error MAL_AP_MATERNO");
				model.put("error", Error.MAL_AP_MATERNO);
				return "redirect:/error";
			
			case Error.MAL_CORREO:
				log.debug("Error MAL_CORREO");
				model.put("error", Error.MAL_CORREO);
				return "redirect:/error";
				
			case Error.MAL_CONTRASENIA:
				log.debug("Error MAL_CONTRASENIA");
				model.put("error", Error.MAL_CONTRASENIA);
				return "redirect:/error";
				
			case Error.MAL_TELEFONO:
				log.debug("Error MAL_TELEFONO");
				model.put("error", Error.MAL_TELEFONO);
				return "redirect:/error";
				
			case Error.MAL_HABILIDADES:
				log.debug("Error MAL_HABILIDADES");
				model.put("error", Error.MAL_HABILIDADES);
				return "redirect:/error";
			
			case Error.MAL_EDAD:
				log.debug("Error MAL_EDAD");
				model.put("error", Error.MAL_EDAD);
				return "redirect:/error";
				
			case Error.MAL_WEB:
				log.debug("Error MAL_WEB");
				model.put("error", Error.MAL_WEB);
				return "redirect:/error";	
			
			case Error.MAL_GR_ACADEMICO:
				log.debug("Error MAL_GR_ACADEMICO");
				model.put("error", Error.MAL_GR_ACADEMICO);
				return "redirect:/error";
				
			default:
				break;
			}
		}
		model.put("enviado", usuarioRegresado);
		return "redirect:/perfil";
	}
	
	@PostMapping("/login")
	public String login(Map <String, Object> model, Usuario usuario) {
		log.debug("Entrando al metodo UsuarioController.login");
		String correo = usuario.getCorreo();
		String contrasenia = usuario.getContrasenia();
		
		Usuario usuarioRegresado = new Usuario();
		
		try {
			usuarioRegresado = usuarioService.findByEmailAndPassword(correo, contrasenia);
			
			if (usuarioRegresado != null) {
				httpSession.setAttribute("userLoggedIn", usuarioRegresado);
				model.put("exitoso", "Login exitoso");
			} else {
				model.put("error", "Error en el correo de usuario o en la contrasenia");
				return "redirect:/error";
			}
		} catch (Exception e) {
			switch (e.getMessage()) {
			case Error.MAL_CORREO:
				model.put("error", Error.MAL_CORREO);
				return "redirect:/error";
				
			case Error.MAL_CONTRASENIA:
				model.put("error", Error.MAL_CONTRASENIA);
				return "redirect:/error";

			default:
				break;
			}
		}
		return "redirect:/perfil";
	}
	
	@GetMapping("/obtenerUsuarios")
	public String obtenerUsuarios(Map <String, Object> model) {
		log.debug("Entrando al metodo UsuarioController.obtenerUsuarios");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			usuarios = usuarioService.findUsuarios();
			
			model.put("usuarios", usuarios);
		} catch (AppExcepcion e) {
			model.put("error", e.getMessage());
			return "redirect:/error";
		}
		
		return "pruebasMarco";
	}
	
	@GetMapping("/obtenerUsuariosPorNombreYTipoDeHabilidad")
	public String obtenerUsuariosPorNombreYTipoDeHabilidad(Map <String, Object> model, 
														   @RequestParam("tipo") String tipo, 
														   @RequestParam("nombre") String nombre) {
		log.debug("Entrando al metodo UsuarioController.obtenerUsuariosPorNombreYTipoDeHabilidad");
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			usuarios = usuarioService.findUsersByHabilidadTipoAndNombre(tipo, nombre);
			
			model.put("usuarios", usuarios);
		} catch (AppExcepcion e) {
			
			switch (e.getMessage()) {
			case Error.MAL_NOM_HABILIDAD:
				log.debug("Error MAL_NOM_HABILIDAD");
				model.put("error", Error.MAL_NOM_HABILIDAD);
				return "redirect:/error";
				
			case Error.MAL_TP_HABILIDAD:
				log.debug("Error MAL_TP_HABILIDAD");
				model.put("error", Error.MAL_TP_HABILIDAD);
				return "redirect:/error";
				
			default:
				break;
			}
		}
		
		
		return "pruebasMarco";
	}
}
