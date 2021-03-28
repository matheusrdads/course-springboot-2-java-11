package com.matheusalbuquerque.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matheusalbuquerque.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice									//intercepta as exceções que acontecerem, para que esse objeto possa executar um possivel tratamenrto
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)																	//necessario para captar a exceção "ResourceNotFoundException" que ocorrer e cair nesse metodo
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";																			// menssagem de erro	
		HttpStatus status = HttpStatus.NOT_FOUND;																		// retorna o erro 404
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);																									// (status) metodo necessario para retornar um resposta com um codigo personalizado
	}
}
