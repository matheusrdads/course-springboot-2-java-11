package com.matheusalbuquerque.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusalbuquerque.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> { //tipo da entidade User e id do tipo Long

}
