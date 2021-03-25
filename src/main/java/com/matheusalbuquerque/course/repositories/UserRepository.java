package com.matheusalbuquerque.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusalbuquerque.course.entities.User;

// nao foi necessario informar o @Repository pois essa interface extends(e herda) de JpaRepoditory que ja esta registrada no spring como objeto disponivel para ser injetado(a indicação @Repository se torna opcional) 
public interface UserRepository extends JpaRepository<User, Long> { //tipo da entidade User e id do tipo Long

}
