package com.matheusalbuquerque.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheusalbuquerque.course.entities.Category; // import da classe Category
import com.matheusalbuquerque.course.services.CategoryService;
// controlado rest respondendo no caminho "/Categorys"
@RestController //anotation informando que essa classe é um recurso web implementado por um controlador rest
@RequestMapping(value = "/categories")//anotation nomeando o recurso e informando o caminho
public class CategoryResource {
	
	@Autowired //Marcando um ponto de injeção de dependencia no spring (fazendo a injecao  de forma transparente tbm para o progamador)
	private CategoryService service;//dependencia para o service
	
	@GetMapping // anotation informando que esse método responde a requisição do tipo GET do HTTP
	public ResponseEntity<List<Category>> finAll() {//método que serve de endpoint para acessar os usuarios (especifico do spring, para retornar respostas de requisições web) nomeando de findAll()
		List<Category> List = service.findAll(); //chamando o servico na operacao finAll
		//Category u = new Category(1L, "Maria", "maria@gmail.com", "9999999", "12345");  instanciando um usuário manualmente e passando seus parametros
		return ResponseEntity.ok().body(List); //ok pra retornar a resposta com sucesso no HTTP, body retornando no corpo da resposta o usuario instanciado "u"
	}
	@GetMapping(value = "/{id}") //informando que a url terá um parametro(passando o id)
	public ResponseEntity<Category> findById(@PathVariable Long id){ //@PathVariable informando ao spring para que ele aceito o parametro id e considera-lo um parametro que chegará na url
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}