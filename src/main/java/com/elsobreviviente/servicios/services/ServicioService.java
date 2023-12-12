package com.elsobreviviente.servicios.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elsobreviviente.servicios.Exception.ErrorDto;
import com.elsobreviviente.servicios.persistence.Servicio;
import com.elsobreviviente.servicios.persistence.ServicioRepository;
import com.elsobreviviente.servicios.persistence.TipoServicioRepository;
import com.elsobreviviente.servicios.persistence.dto.ServicioDto;
import com.elsobreviviente.servicios.persistence.dto.ServicioIdDto;
import com.elsobreviviente.servicios.persistence.dto.ServicioNewDto;

@Service
public class ServicioService {
	
	@Autowired
	ServicioRepository serviceRepository;
	
	@Autowired
	TipoServicioRepository tipoServicioRepository;
	
	
	public List<Servicio> findByNombreServicioContainingIgnoreCase ( String cadena ){
		return serviceRepository.findByNombreServicioContainingIgnoreCase(cadena);
	}
	
	
	public List<Servicio> findByNombreServicioStartingWithIgnoreCase ( String cadena ){
		return serviceRepository.findByNombreServicioContainingIgnoreCase(cadena);
	}
	
	/*
	 * convertir entity a dto
	 * */
	public List<ServicioDto> findByNombreServicio ( String cadena ) {
		List<ServicioDto> listaServiciosDto = new ArrayList<>();
		List<Servicio> listaServicios =	findByNombreServicioContainingIgnoreCase(cadena);
		for ( Servicio servicio : listaServicios ) {
			ServicioDto servicioDto = new ServicioDto ( servicio.getIdCodigoServicio(), servicio.getCodigoServicio(), servicio.getNombreServicio() );
			listaServiciosDto.add( servicioDto );
		}
		return listaServiciosDto;
	}
	
	
	public ServicioDto almacenarServicio ( ServicioDto servicioDto ) {
		//convertir dto a entity
		Servicio servicio = new Servicio();
		servicio.setCodigoServicio( servicioDto.getCodigoServicio()  );
		servicio.setNombreServicio(servicioDto.getNombreServicio());
		serviceRepository.save( servicio ); //persistiendo
		return servicioDto;
	}
	
	
	public ServicioNewDto almacenarServicioV2 ( ServicioNewDto servicioNewDto ) {
		//convertir dto a entity
		Servicio servicio = new Servicio();
		servicio.setCodigoServicio( servicioNewDto.getCodigoServicio()  );  //set
		servicio.setNombreServicio( servicioNewDto.getNombreServicio() );   //set
		servicio.setTiposervicio   (   tipoServicioRepository.getReferenceById( servicioNewDto.getCodigoTipoServicio() )  );   
		serviceRepository.save( servicio ); //persistiendo
		return servicioNewDto;
	}
	public ServicioNewDto actualizarServicio ( ServicioNewDto servicioNewDto ) {
		Servicio servicio =  serviceRepository.findByIdCodigoServicio( servicioNewDto.getIdCodigoServicio()    );
		
		if ( servicio != null) {
			servicio.setCodigoServicio( servicioNewDto.getCodigoServicio()  );  //set
			servicio.setNombreServicio( servicioNewDto.getNombreServicio() );   //set
			servicio.setTiposervicio   (   tipoServicioRepository.getReferenceById( servicioNewDto.getCodigoTipoServicio() )  );   
			serviceRepository.save( servicio ); //persistiendo
			return servicioNewDto;
		} else {
			return null;
		}	
	}
	

	public boolean eliminarServicio ( ServicioIdDto servicioIdDto ) {
		
		Servicio servicio  = serviceRepository.findByIdCodigoServicio ( servicioIdDto.getIdCodigoServicio());
		if ( servicio != null) {
			serviceRepository.delete(servicio);
			return true;
		} else {
			return false;
		}
	}
		public ErrorDto eliminarServicioV2 ( ServicioIdDto servicioIdDto ) {
			
			Servicio servicio  = serviceRepository.findByIdCodigoServicio ( servicioIdDto.getIdCodigoServicio());
			if ( servicio != null) {
				serviceRepository.delete(servicio);
				return new ErrorDto(" servicio eliminado" );
				
			} else {
				return new ErrorDto ("servicio no existe");
			}
		
	}
	
}