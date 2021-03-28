package com.matheusalbuquerque.course.services.exceptions;

//configurando uma exceção personalizada

public class ResourceNotFoundException extends RuntimeException {		//"RuntimeException" classe de exceção que o compilador não exige um tratamento 
	private static final long serialVersionUID = 1L; 			

	public ResourceNotFoundException(Object id) {						//passando o id do objeto que não foi encontrado
		super("Resource not found. Id" + id);							//Enviando a mensagem e concatenando com o id nao encontrado		
	}
}
