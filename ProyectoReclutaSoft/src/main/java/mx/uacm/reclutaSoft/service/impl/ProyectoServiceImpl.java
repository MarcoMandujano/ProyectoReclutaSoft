package mx.uacm.reclutaSoft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Rol;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.ProyectoRepository;
import mx.uacm.reclutaSoft.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	private static final Logger log = LogManager.getLogger(ProyectoServiceImpl.class);
	
	@Autowired
	private ProyectoRepository proyectoRepository;
	
	public Proyecto alta(String nombre, String descripcion, ArrayList<Rol> roles) throws AppExcepcion {
		
		log.debug("Entrando a alta");
			
		Proyecto proyecto = null;
				
		if (nombre.length() < Regla.MIN_NOM_PROYECTO || nombre.length() > Regla.MAX_NOM_PROYECTO) {
			throw new AppExcepcion(Error.MAL_NOM_PROYECTO, Error.NO_LONGITUD);
		}
		
		if (descripcion.length() < Regla.MIN_DES_PROYECTO || descripcion.length() > Regla.MAX_DES_PROYECTO) {
			throw new AppExcepcion(Error.MAL_DES_PROYECTO, Error.NO_LONGITUD);
		}
				
		if (roles.isEmpty()) {
			throw new AppExcepcion(Error.MAL_ROLES, Error.NO_NULL);
		}
				
		proyecto = new Proyecto();
		proyecto.setNombre(nombre);
		proyecto.setDescripcion(descripcion);
		proyecto.setRoles(roles);
				
		//proyectoRepository.save(proyecto);		
		return proyecto;
	}
	
	//falta probar
	public List<Proyecto> findPoryectos() throws AppExcepcion {
		log.debug("Entrando a ProyectoServiceImpl.findPoryectos");
		
		List<Proyecto> proyectos = new ArrayList<Proyecto>();
		
		proyectos = proyectoRepository.findAllProjects();
		
		return proyectos;
	}
}































