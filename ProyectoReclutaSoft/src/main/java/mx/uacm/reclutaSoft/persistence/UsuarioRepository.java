package mx.uacm.reclutaSoft.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mx.uacm.reclutaSoft.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query(value="select * from Usuario where correo = :correo AND contrasenia = MD5(:contrasenia)", nativeQuery=true)
	Usuario findByEmailAndPassword(@Param("correo") String email,@Param("contrasenia") String password);
	
	@Query(value="select * from Usuario", nativeQuery=true)
	List<Usuario> findAllUsers();
	
	@Query(value="SELECT * FROM Usuario where id in (select usuario_id from Habilidad where tipo = :tipo and nombre = :nombreHabilidad)", nativeQuery=true)
	List<Usuario> findUsersByHabilidadTipoAndNombre(@Param("tipo") String tipo, @Param("nombreHabilidad") String nombreHabilidad);
}
