package com.elsobreviviente.servicios.Exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice ( annotations = RestController.class)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
    
	public ResponseEntity<Object> handleAllExceptions(     Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		ErrorDto errorDto = new ErrorDto ();
		errorDto.setError( ex.getMessage());
		return new ResponseEntity<Object>( errorDto, HttpStatus.BAD_REQUEST);
        //return new ResponseEntity<>( ex.getMessage(), HttpStatus.NOT_FOUND);
    }



}
