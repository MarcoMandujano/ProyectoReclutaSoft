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

import mx.uacm.reclutaSoft.Application;
import mx.uacm.reclutaSoft.constantes.Error;
import mx.uacm.reclutaSoft.constantes.Regla;
import mx.uacm.reclutaSoft.domain.Habilidad;
import mx.uacm.reclutaSoft.domain.Usuario;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.HabilidadService;
import mx.uacm.reclutaSoft.service.UsuarioService;
import mx.uacm.reclutaSoft.service.impl.HabilidadServiceImpl;
import mx.uacm.reclutaSoft.service.impl.UsuarioServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class UsuarioServiceImplTest {
	private static final Logger log = LogManager.getLogger(UsuarioServiceImplTest.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private HabilidadService habilidadService; 
	
//	private UsuarioService usuarioService = new UsuarioServiceImpl();
//	private HabilidadService habilidadService = new HabilidadServiceImpl();	
	@Test
	public void testNombreLongMin() {
		log.debug("Entrando a testNombreLongMin");
		
		String nombre = "Mar";
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
	
//	@Test
//	public void testNombreLongMax() {
//		log.debug("Entrando a testNombreLongMax");
//		
//		String nombre = "a";
//		
//		for (int i = 0; i < Regla.LONG_MAX_NOMBRE; i++) {
//			nombre += "a";
//		}
//		
//		String apellidoPaterno = "";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_NOMBRE, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testNombreCaracteres() {
//		log.debug("Entrando a testNombreCaracteres");
//		
//		String nombre = "Marco1";
//		String apellidoPaterno = "";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_NOMBRE, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testApPaternoLongMin() {
//		log.debug("Entrando a testApPaternoLongMin");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Man";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_AP_PATERNO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testApPaternoLongMax() {
//		log.debug("Entrando a testApPaternoLongMax");
//		
//		String nombre = "Marco";				
//		String apellidoPaterno = "a";
//		
//		for (int i = 0; i < Regla.LONG_MAX_PATERNO; i++) {
//			apellidoPaterno += "a";
//		}
//				
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_AP_PATERNO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testApPaternoCaracteres() {
//		log.debug("Entrando a testApPaternoCaracteres");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano1";
//		String apellidoMaterno = "";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_AP_PATERNO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testApMaternoLongMin() {
//		log.debug("Entrando a testApMaternoLongMin");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Her";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_AP_MATERNO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testApMaternoLongMax() {
//		log.debug("Entrando a testApMaternoLongMax");
//		
//		String nombre = "Marco";				
//		String apellidoPaterno = "Mandujano";			
//		String apellidoMaterno = "a";
//
//		for (int i = 0; i < Regla.LONG_MAX_MATERNO; i++) {
//			apellidoMaterno += "a";
//		}
//		
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_AP_MATERNO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testApMaternoCaracteres() {
//		log.debug("Entrando a testApMaternoCaracteres");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez1";
//		String correo = "";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_AP_MATERNO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testCorreo() {
//		log.debug("Entrando a testCorreo");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "$%@&/.)<>";
//		String contrasenia = "";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_CORREO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testContraseniaMin() {
//		log.debug("Entrando a testContraseniaMin");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwe";
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_CONTRASENIA, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testContraseniaMax() {
//		log.debug("Entrando a testContraseniaMax");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty1234567";		
//		String telefono = "";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_CONTRASENIA, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testTelefonoNumeros() {
//		log.debug("Entrando a testTelefonoMax");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "123456789A";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_TELEFONO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testTelefonoLong() {
//		log.debug("Entrando a testTelefonoLong");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";
//		String telefono = "1578";
//		ArrayList<Habilidad> habilidades = null;
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_TELEFONO, e.getMessage());
//		}
//	}
//			
//	@Test
//	public void testHabilidades() {
//		log.debug("Entrando a testHabilidades");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "1547896358";
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
//		int edad = 0;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_HABILIDADES, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testEdadMin() {
//		log.debug("Entrando a testEdadMin");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "1547896358";
//		
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
//		String nomHabilidad = "C";
//		String tipo = "Lenguaje de programación";		
//		int puntuacion = 5;
//				
//		int edad = 17;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_EDAD, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testEdadMax() {
//		log.debug("Entrando a testEdadMax");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "1547896358";
//		
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
//		String nomHabilidad = "C";
//		String tipo = "Lenguaje de programación";		
//		int puntuacion = 5;
//				
//		int edad = 101;
//		String web = "";
//		String titulo = "";
//		
//		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_EDAD, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testSitioWeb() {
//		log.debug("Entrando a testSitioWeb");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "1547896358";
//		
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
//		String nomHabilidad = "C";
//		String tipo = "Lenguaje de programación";		
//		int puntuacion = 5;
//				
//		int edad = 18;
//		String web = "http://marco!mandujanoQ567/index";
//		String titulo = "";
//		
//		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_WEB, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testGradoAcademico() {
//		log.debug("Entrando a testGradoAcademico");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "1547896358";
//		
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
//		String nomHabilidad = "C";
//		String tipo = "Lenguaje de programación";		
//		int puntuacion = 5;
//				
//		int edad = 18;
//		String web = "http://marcoWeb.com/info";
//		String titulo = "Profesor";
//		
//		try {
//			habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//			usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno, correo, contrasenia, telefono, habilidades, edad, web, titulo);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_GR_ACADEMICO, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testAlta() throws AppExcepcion {
//		log.debug("Entrando a testAlta");
//		
//		String nombre = "Marco";
//		String apellidoPaterno = "Mandujano";
//		String apellidoMaterno = "Hernandez";
//		String correo = "marco.madujano@gmail.com";
//		String contrasenia = "qwerty123";		
//		String telefono = "1547896358";
//		
//		ArrayList<Habilidad> habilidades = new ArrayList<Habilidad>();
//		String nomHabilidad = "C";
//		String tipo = "Lenguaje de programación";		
//		int puntuacion = 5;
//				
//		int edad = 18;
//		String web = "http://marcoWeb.com/info";
//		String titulo = "Estudiante";
//		
//		habilidades.add(habilidadService.alta(nomHabilidad, tipo, puntuacion));			
//		Usuario usuario = usuarioService.alta(nombre, apellidoPaterno, apellidoMaterno,
//				correo, contrasenia, telefono, habilidades, edad, web, titulo);
//		
//		Assert.assertNotNull(usuario);
//	}
//	
//	@Test
//	public void testReputacionMin() {
//		log.debug("Entrando a testReputacionMin");
//		
//		Usuario usuario = null;
//		String correo = "marco.madujano@gmail.com";
//		
//		int reputacion = -1;
//		
//		try {
//			usuario = usuarioService.findUsuario(correo);
//			usuarioService.setReputacion(usuario, reputacion);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_REPUTACION, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testReputacionMax() {
//		log.debug("Entrando a testReputacionMax");
//		
//		Usuario usuario = null;
//		String correo = "marco.madujano@gmail.com";
//		
//		int reputacion = 6;
//		
//		try {
//			usuario = usuarioService.findUsuario(correo);
//			usuarioService.setReputacion(usuario, reputacion);
//			
//		} catch (AppExcepcion e) {
//			Assert.assertEquals(Error.MAL_REPUTACION, e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testSetReputacion() throws AppExcepcion {
//		log.debug("Entrando a testSetReputacion");
//		
//		Usuario usuario = null;
//		String correo = "marco.madujano@gmail.com";
//		
//		int reputacion = 5;
//		
//		usuario = usuarioService.findUsuario(correo);
//		usuario = usuarioService.setReputacion(usuario, reputacion);
//		
//		Assert.assertEquals(usuario.getReputacion(), reputacion);
//	}
}
