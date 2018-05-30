package mx.uacm.reclutaSoft.service.test.impl;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.UsuarioService;
import mx.uacm.reclutasoftw.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class UsuarioServiceImplTest {
	private static final Logger log = LogManager.getLogger(UsuarioServiceImplTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	public void testNombreCaracteres() {
		log.debug("Entrando a testNombreCaracteres");
		
		String nombre = "";
		String apellidoPaterno = "";
		String apellidoMaterno = "";
		String correo = "";
		String contrasenia = "";
		String telefono = "";
		ArrayList<Habilidad> habilidades = null;
		int edad = 0;
		String web = "";
		String titulo = "";
		
		try {
			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOMBRE, e.getMessage());
		}
	}
}
