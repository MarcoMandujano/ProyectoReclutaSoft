package mx.uacm.reclutaSoft.service.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.persistence.HabilidadRepository;
import mx.uacm.reclutaSoft.service.HabilidadService;

public class HabilidadServiceImpl implements HabilidadService {

	private static final Logger log = LogManager.getLogger(HabilidadServiceImpl.class);
	
	@Autowired
	private HabilidadRepository habilidadRepository;
	
	public Habilidad alta (String nombre, String tipo, int puntuacion) throws AppExcepcion {
		log.debug("Entrando a alta");
		
		Habilidad habilidad = null;
		
		if (!(nombre.matches(Regla.REGEX_NOM_HABILIDAD))) {
			throw new AppExcepcion(Error.MAL_NOM_HABILIDAD, Error.NO_LET_ESP_NUM);
		}
		
		if (nombre.length() < Regla.LONG_MIN_HABILIDAD || nombre.length() > Regla.LONG_MAX_HABILIDAD) {
			throw new AppExcepcion(Error.MAL_NOM_HABILIDAD, Error.NO_LONGITUD);
		}
		
		if (!Regla.TIPO_HABILIDAD.contains(tipo)) {
			throw new AppExcepcion(Error.MAL_TP_HABILIDAD, Error.NO_ENCONTRADO);
		}
		
		if (puntuacion < Regla.MIN_PUNTUACION || puntuacion > Regla.MAX_PUNTUACION) {
			throw new AppExcepcion(Error.MAL_PT_HABILIDAD, Error.NO_RANGO);
		}
		
		//habilidadRepository.save(habilidad);
		
		return habilidad;
	}
	
	
}
