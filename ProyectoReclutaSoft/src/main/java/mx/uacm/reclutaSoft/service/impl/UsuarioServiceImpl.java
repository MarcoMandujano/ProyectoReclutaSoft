package mx.uacm.reclutaSoft.service.impl;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.UsuarioRepository;
import mx.uacm.reclutaSoft.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {
	
	private static final Logger log = LogManager.getLogger(UsuarioServiceImpl.class);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario alta(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, 
			String telefono, ArrayList<Habilidad> habilidades, int edad, String web, String titulo) throws AppExcepcion {
		
		log.debug("Entrando a alta");
			
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
		
		if (telefono.length() == Regla.LONG_TELEFONO) {
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
		
		//usuarioRepository.save(usuario);		
		return usuario;
	}
}
