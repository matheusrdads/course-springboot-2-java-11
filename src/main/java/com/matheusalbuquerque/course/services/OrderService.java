package com.matheusalbuquerque.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusalbuquerque.course.entities.Order;
import com.matheusalbuquerque.course.repositories.OrderRepository;

@Service//(component registration): registrando a classe no spring para que ela fique disponivel na lista de objetos que podem ser injetados(Outras anotations com semanticas especificas @Component e @Repository)
public class OrderService {

	@Autowired //Marcando um ponto de injeção de dependencia no spring (fazendo a injecao  de forma transparente tbm para o progamador)
	private OrderRepository repository; //OrderService depende de OrderRepository (injeção de dependencias)
	
	public List<Order> findAll() { // camada de servico repassando a chamada para o repository.findAll()
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id); // "optional" pode ou nao ter um valor
		return obj.get(); //reotrna o objeto do tipo "Order" que estiver dentro de optional
	}
}
