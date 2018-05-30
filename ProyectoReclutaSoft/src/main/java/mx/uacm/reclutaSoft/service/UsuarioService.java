package mx.uacm.reclutaSoft.service;

import java.util.ArrayList;

import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface UsuarioService {
	
	public Usuario alta(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, 
			String telefono, ArrayList<Habilidad> habilidades, int edad, String web, String titulo) throws AppExcepcion;
}
