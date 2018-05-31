package mx.uacm.reclutaSoft.persistence;

import org.springframework.data.repository.CrudRepository;

import mx.uacm.reclutaSoft.domain.Proyecto;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

}
