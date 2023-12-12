package com.elsobreviviente.servicios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elsobreviviente.servicios.Exception.ErrorDto;
import com.elsobreviviente.servicios.persistence.dto.ServicioDto;
import com.elsobreviviente.servicios.persistence.dto.ServicioIdDto;
import com.elsobreviviente.servicios.persistence.dto.ServicioNewDto;
import com.elsobreviviente.servicios.services.ServicioService;


@RestController
@RequestMapping ("/elsobreviviente/servicio")
public class ServicioSaludController {
	
	@Autowired
	ServicioService servicioService;
	
	@GetMapping ("/saludar")
	public String saludar()	{
		return "Hola mundo!!!";
	}
	
	@GetMapping ("/cantidadServicios/{cadena}")
	public int cantidadServicios (@PathVariable("cadena")String cadena) {
		return servicioService.findByNombreServicioContainingIgnoreCase(cadena).size();
	}

@GetMapping ("/cantidadServiciosComienzanCon/{cadena}")
public int cantidadServiciosComienzanCon (String cadena) {
	return servicioService.findByNombreServicioStartingWithIgnoreCase(cadena).size();
}

@GetMapping ("/listaServicios/{cadena}")
public ResponseEntity<List<ServicioDto>> listarServiciosPorCadena ( @PathVariable("cadena")  String cadena  ) {
	return new ResponseEntity<>(  servicioService.findByNombreServicio(cadena), HttpStatus.OK);
}

@PostMapping ("/almacenar")
public ResponseEntity<ServicioDto> almacenarServicio (@RequestBody ServicioDto servicioDto ) {
	System.out.println (servicioDto);
	return new ResponseEntity <> ( servicioService.almacenarServicio(servicioDto), HttpStatus.CREATED);
}

@PostMapping ("/almacenarNew")
public ResponseEntity<ServicioNewDto> almacenarServicioNew (@RequestBody ServicioNewDto servicioNewDto ) {
	System.out.println (servicioNewDto);
	return new ResponseEntity<>(  servicioService.almacenarServicioV2(servicioNewDto), HttpStatus.CREATED);
}

@PutMapping ("/actualizar")
public ResponseEntity<ServicioNewDto> actualizarServicioNew (@RequestBody ServicioNewDto servicioNewDto ) {
	
	if ( servicioService.actualizarServicio(servicioNewDto) !=null ) {
		return new ResponseEntity(HttpStatus.OK);
	} else {
		return new ResponseEntity(HttpStatus.NOT_FOUND );
	}
	
}

	@DeleteMapping ("/eliminarServicio")
	public ResponseEntity eliminarServicio ( @RequestBody ServicioIdDto servicioIdDto ) {
		
		if (	servicioService.eliminarServicio(servicioIdDto) ) {
			return new ResponseEntity(HttpStatus.OK); 
		} else {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping ("/eliminarServicioV2")
	public ResponseEntity<ErrorDto> eliminarServicioV2 ( @RequestBody ServicioIdDto servicioIdDto ) {
		
		ErrorDto salida = servicioService.eliminarServicioV2(servicioIdDto);
		return  new ResponseEntity( salida, HttpStatus.ACCEPTED);
		
	}	
	
	
}
	




