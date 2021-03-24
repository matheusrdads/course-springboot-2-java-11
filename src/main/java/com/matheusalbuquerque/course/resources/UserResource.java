package com.matheusalbuquerque.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusalbuquerque.course.entities.User; // import da classe User
// controlado rest respondendo no caminho "/users"
@RestController //anotation informando que essa classe é um recurso web implementado por um controlador rest
@RequestMapping(value = "/users")//anotation nomeando o recurso e informando o caminho
public class UserResource {
	
	@GetMapping // anotation informando que esse método responde a requisição do tipo GET do HTTP
	public ResponseEntity<User> finAll() {//método que serve de endpoint para acessar os usuarios (especifico do spring, para retornar respostas de requisições web) nomeando de findAll()
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345"); // instanciando um usuário e passando seus parametros
		return ResponseEntity.ok().body(u); //ok pra retornar a resposta com sucesso no HTTP, body retornando no corpo da resposta o usuario instanciado "u"
	}
}