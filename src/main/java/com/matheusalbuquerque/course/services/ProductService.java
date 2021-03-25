package com.matheusalbuquerque.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusalbuquerque.course.entities.Product;
import com.matheusalbuquerque.course.repositories.ProductRepository;

@Service     //(component registration): registrando a classe no spring para que ela fique disponivel na lista de objetos que podem ser injetados(Outras anotations com semanticas especificas @Component e @Repository)
public class ProductService {

	@Autowired     //Marcando um ponto de injeção de dependencia no spring (fazendo a injecao  de forma transparente tbm para o progamador)
	private ProductRepository repository;     //ProductService depende de ProductRepository (injeção de dependencias)
	
	public List<Product> findAll() {     //camada de servico repassando a chamada para o repository.findAll()
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);     //"optional" pode ou nao ter um valor
		return obj.get();     //reotrna o objeto do tipo "Product" que estiver dentro de optional
	}
}
