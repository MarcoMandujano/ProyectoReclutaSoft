package mx.uacm.reclutaSoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.UsuarioRepository;
import mx.uacm.reclutaSoft.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger log = LogManager.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario alta(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, 
			String telefono, List<Habilidad> habilidades, int edad, String web, String titulo) throws AppExcepcion {
		
		log.debug("Entrando a UsuarioServiceImpl.alta");
			
		Usuario usuario = null;
		
		if (!(nombre.matches(Regla.REGEX_NOMBRE))) {
			throw new AppExcepcion(Error.MAL_NOMBRE, Error.NO_LETRAS_ESPACIOS);
		}
		
		if (nombre.length() < Regla.LONG_MIN_NOMBRE || nombre.length() > Regla.LONG_MAX_NOMBRE) {
			throw new AppExcepcion(Error.MAL_NOMBRE, Error.NO_LONGITUD);
		}
		
		if (!(apellidoPaterno.matches(Regla.REGEX_AP_PATERNO))) {
			throw new AppExcepcion(Error.MAL_AP_PATERNO, Error.NO_LETRAS);
		}
		
		if (apellidoPaterno.length() < Regla.LONG_MIN_PATERNO || apellidoPaterno.length() > Regla.LONG_MAX_PATERNO) {
			throw new AppExcepcion(Error.MAL_AP_PATERNO, Error.NO_LONGITUD);
		}
		
		if (!(apellidoMaterno.matches(Regla.REGEX_AP_MATERNO))) {
			throw new AppExcepcion(Error.MAL_AP_MATERNO, Error.NO_LETRAS);
		}
		
		if (apellidoMaterno.length() < Regla.LONG_MIN_MATERNO || apellidoMaterno.length() > Regla.LONG_MAX_MATERNO) {
			throw new AppExcepcion(Error.MAL_AP_MATERNO, Error.NO_LONGITUD);
		}
		
		if (!(correo.matches(Regla.REGEX_CORREO))) {
			throw new AppExcepcion(Error.MAL_CORREO, Error.NO_CORREO);
		}
		
		if (contrasenia.length() < Regla.LONG_MIN_CONTRASENIA || contrasenia.length() > Regla.LONG_MAX_CONTRASENIA) {
			throw new AppExcepcion(Error.MAL_CONTRASENIA, Error.NO_LONGITUD);
		}
		
		if (!(telefono.matches(Regla.REGEX_TELEFONO))) {
			throw new AppExcepcion(Error.MAL_TELEFONO, Error.NO_NUMEROS);
		}
		
		if (telefono.length() != Regla.LONG_TELEFONO) {
			throw new AppExcepcion(Error.MAL_TELEFONO, Error.NO_LONGITUD);
		}
		
		if (habilidades.isEmpty()) {
			throw new AppExcepcion(Error.MAL_HABILIDADES, Error.NO_NULL);
		}
		
		if (edad < Regla.MIN_EDAD || edad > Regla.MAX_EDAD) {
			throw new AppExcepcion(Error.MAL_EDAD, Error.NO_RANGO);
		}
		
		if (!(web.matches(Regla.REGEX_WEB))) {
			throw new AppExcepcion(Error.MAL_WEB, Error.NO_WEB);
		}
		
		if (!Regla.GRADO_ACADEMICO.contains(titulo)) {
			throw new AppExcepcion(Error.MAL_GR_ACADEMICO, Error.NO_ENCONTRADO);
		}
		
		usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellidoPaterno(apellidoPaterno);
		usuario.setApellidoMaterno(apellidoMaterno);
		usuario.setCorreo(correo);
		usuario.setContrasenia(contrasenia);
		usuario.setTelefono(telefono);
		usuario.setHabilidades(habilidades);
		usuario.setEdad(edad);
		usuario.setWeb(web);
		usuario.setTitulo(titulo);
		
		usuarioRepository.save(usuario);		
		return usuario;
	}
	
	public Usuario setReputacion(Usuario usuario, int reputacion) throws AppExcepcion {	
		log.debug("Entrando a setReputacion");
				
		if (reputacion < Regla.MIN_REPUTACION || reputacion > Regla.MAX_REPUTACION) {
			throw new AppExcepcion(Error.MAL_REPUTACION, Error.NO_RANGO);
		}
		
		//usuario = usuarioRepository
		usuario.setReputacion(reputacion);
		return usuario;
	}
	
	public Usuario setPartcicipacion(Usuario usuario, Proyecto proyecto) throws AppExcepcion {
		log.debug("Entrando a setPartcicipacion");
		
		return usuario;
	}
	
	public Usuario findUsuario(String correo) throws AppExcepcion {
		log.debug("Entrando a findUsuario");
		
		//Usuario usuario = usuarioRepository.find
		
		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
		String nomHabilidad = "C";
		String tipo = "Lenguaje de progrmación";		
		int puntuacion = 5;
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Marco");
		usuario.setApellidoPaterno("Mandujano");
		usuario.setApellidoMaterno("Hernandez");
		usuario.setCorreo(correo);
		usuario.setContrasenia("qwerty123");
		usuario.setTelefono("1547896358");
		usuario.setHabilidades(habilidades);
		usuario.setEdad(18);
		usuario.setWeb("http://marcoWeb.com/info");
		usuario.setTitulo("Estudiante");
		
		return usuario;
	}
	
	//falta hacer test
	public Usuario findByEmailAndPassword(String correo, String contrasenia) throws AppExcepcion {
		log.debug("Entrando a UsuarioServiceImpl.findByEmailAndPassword");
		
		if (!(correo.matches(Regla.REGEX_CORREO))) {
			throw new AppExcepcion(Error.MAL_CORREO, Error.NO_CORREO);
		}
		
		if (contrasenia.length() < Regla.LONG_MIN_CONTRASENIA || contrasenia.length() > Regla.LONG_MAX_CONTRASENIA) {
			throw new AppExcepcion(Error.MAL_CONTRASENIA, Error.NO_LONGITUD);
		}
		
		Usuario usuario = new Usuario();
		
		usuario = usuarioRepository.findByEmailAndPassword(correo, contrasenia);
		
				
		return usuario;
	}
	
	//falta hacer test
	public List<Usuario> findUsuarios() throws AppExcepcion {
		log.debug("Entrando a UsuarioServiceImpl.findUsuarios");
		
//		List<Usuario> usuarios = Lists.newArrayList(usuarioRepository.findAll());
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios = usuarioRepository.findAllUsers();
		
		return usuarios;
	}
}
