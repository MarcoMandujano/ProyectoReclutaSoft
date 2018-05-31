package mx.uacm.reclutaSoft.domain;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/** hola
 * 
 * @author marco
 *
 */
@Entity
public class Rol {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="proyecto_id")
	private Proyecto proyecto;
	
	private String nombre;
	
	@OneToMany(mappedBy="rol", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private ArrayList<Usuario> usuarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setUsuario(Usuario usuario) {
		usuarios.add(usuario);
		usuario.setRol(this);
	}
	
	public void removeUsuario(Usuario usuario) {
		usuarios.remove(usuario);
		usuario.setRol(null);
	}
}
