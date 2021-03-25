package com.matheusalbuquerque.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusalbuquerque.course.entities.Order;

// nao foi necessario informar o @Repository pois essa interface extends(e herda) de JpaRepoditory que ja esta registrada no spring como objeto disponivel para ser injetado(a indicação @Repository se torna opcional) 
public interface OrderRepository extends JpaRepository<Order, Long> { //criando um repository passando o tipo da entidade Order e id do tipo Long (como referencia)

}
