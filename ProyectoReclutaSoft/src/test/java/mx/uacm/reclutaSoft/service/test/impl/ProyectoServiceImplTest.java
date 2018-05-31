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
import mx.uacm.reclutaSoft.domain.Proyecto;
import mx.uacm.reclutaSoft.domain.Rol;
import mx.uacm.reclutaSoft.excepcion.AppExcepcion;
import mx.uacm.reclutaSoft.service.ProyectoService;
import mx.uacm.reclutaSoft.service.impl.ProyectoServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class ProyectoServiceImplTest {
	private static final Logger log = LogManager.getLogger(ProyectoServiceImplTest.class);
	
//	@Autowired
//	private ProyectoService proyectoService;
	
	private ProyectoService proyectoService = new ProyectoServiceImpl();
		
	@Test
	public void testNombreMin() {
		log.debug("Entrando a testNombreMin");
		
		String nombre = "";
		String descripcion = "";
		ArrayList<Rol> roles = null;
				
		try {
			proyectoService.alta(nombre, descripcion, roles);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_PROYECTO, e.getMessage());
		}
	}
	
	@Test
	public void testNombreMax() {
		log.debug("Entrando a testNombreMax");
		
		String nombre = "a";
		
		for (int i = 0; i < Regla.MAX_NOM_PROYECTO; i++) {
			nombre += "a";
		}
		
		String descripcion = "";
		ArrayList<Rol> roles = null;
				
		try {
			proyectoService.alta(nombre, descripcion, roles);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_NOM_PROYECTO, e.getMessage());
		}
	}
		
	@Test
	public void testDescripcionMin() {
		log.debug("Entrando a testDescripcionMin");
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "";
		ArrayList<Rol> roles = null;
				
		try {
			proyectoService.alta(nombre, descripcion, roles);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_DES_PROYECTO, e.getMessage());
		}
	}
	
	@Test
	public void testDescripcionMax() {
		log.debug("Entrando a testDescripcionMax");
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "a";
		
		for (int i = 0; i < Regla.MAX_DES_PROYECTO; i++) {
			descripcion += "a";
		}
		
		ArrayList<Rol> roles = null;
				
		try {
			proyectoService.alta(nombre, descripcion, roles);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_DES_PROYECTO, e.getMessage());
		}
	}
	
	@Test
	public void testRoles() {
		log.debug("Entrando a testRoles");
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "Proyecto #1 de la historia";		
		ArrayList<Rol> roles = new ArrayList<Rol>();
				
		try {
			proyectoService.alta(nombre, descripcion, roles);
			
		} catch (AppExcepcion e) {
			Assert.assertEquals(Error.MAL_ROLES, e.getMessage());
		}
	}
	
	@Test
	public void testAlta() throws AppExcepcion {
		log.debug("Entrando a testAlta");
		
		String nombre = "Proyecto Alcancia Digital";
		String descripcion = "Proyecto #1 de la historia";
		
		ArrayList<Rol> roles = new ArrayList<Rol>();
		Rol rol = new Rol();
		rol.setNombre("Programador");
		
		roles.add(rol);
				
		Proyecto proyecto =	proyectoService.alta(nombre, descripcion, roles);
		
		Assert.assertNotNull(proyecto);
	}
}
