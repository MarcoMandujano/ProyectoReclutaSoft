package mx.uacm.reclutaSoft.service;

import java.util.ArrayList;
import java.util.List;

import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;

public interface UsuarioService {
	
	public Usuario alta(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String contrasenia, 
			String telefono, List<Habilidad> habilidades, int edad, String web, String titulo) throws AppExcepcion;
	
	public Usuario setReputacion(Usuario usuario, int reputacion) throws AppExcepcion;
		
	public Usuario setPartcicipacion(Usuario usuario, Proyecto proyecto) throws AppExcepcion;
	
	public Usuario findUsuario(String correo) throws AppExcepcion;
}
