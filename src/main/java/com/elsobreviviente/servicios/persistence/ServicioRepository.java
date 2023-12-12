package com.elsobreviviente.servicios.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long>{
	Servicio  findByCodigoServicio ( String codigoServicio );
	Servicio  findByIdCodigoServicio ( Long idCodigoServicio );
	List<Servicio> findByNombreServicioContainingIgnoreCase(String cadena);
	List<Servicio> findByNombreServicioStartingWithIgnoreCase(String cadena);
	
	
}