package com.matheusalbuquerque.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusalbuquerque.course.entities.User; // import da classe User
import com.matheusalbuquerque.course.services.UserService;
// controlado rest respondendo no caminho "/users"

@RestController 											//(componet registration)registrando essa classe no spring, como objeto que pede ser injetado. Anotation informando que essa classe é um recurso web implementado por um controlador rest
@RequestMapping(value = "/users")							//anotation nomeando o recurso e informando o caminho
public class UserResource {
	
	@Autowired 												//Marcando um ponto de injeção de dependencia no spring (fazendo a injecao  de forma transparente tbm para o progamador)
	private UserService service;							//dependencia para o service (chamando tudo de UserService)
	
	@GetMapping 											//anotation informando que esse método responde a requisição do tipo GET do HTTP
	public ResponseEntity<List<User>> finAll() {			//método que serve de endpoint para acessar os usuarios (especifico do spring, para retornar respostas de requisições web) nomeando de findAll()
		List<User> List = service.findAll(); 				//chamando o servico na operacao finAll que retorna uma lista com todos os usuarios
															//User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");  instanciando um usuário manualmente e passando seus parametros
		return ResponseEntity.ok().body(List); 				//ok pra retornar a resposta com sucesso no HTTP, body retornando no corpo da resposta o usuario instanciado contido na lista List
	}
	@GetMapping(value = "/{id}") 										//informando que a url terá um parametro(passando o id)
	public ResponseEntity<User> findById(@PathVariable Long id){ 		//@PathVariable informando ao spring para que ele aceito o parametro id e considera-lo um parametro que chegará na url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {						//end point recebento um objeto do tipo user. @RequestBody recenbendo os dados no corpo da requisição 
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);									// no padrao HTTP quando retornamos um 201, é esperado que a resposta contenha um cabecalho chamado location contendo o novo indereço que voce inseriu
	}
	
	@DeleteMapping(value = "/{id}") 													//passando o id que sera deletado
	public ResponseEntity<Void> delete(@PathVariable Long id){							// @PathVariable para o Long id ser reconhecido como uma variavel da url
		service.delete(id);
		return ResponseEntity.noContent().build();										// noContent retorna uma resposta vazia ja com o codigo 204
	}
	
	@PutMapping(value = "/{id}") 
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){
		obj = service.update(id, obj);													//usuario atualizado
		return ResponseEntity.ok().body(obj);
	}
}