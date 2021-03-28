package com.matheusalbuquerque.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusalbuquerque.course.entities.User;
import com.matheusalbuquerque.course.repositories.UserRepository;

@Service     				//(component registration): registrando a classe no spring para que ela fique disponivel na lista de objetos que podem ser injetados(Outras anotations com semanticas especificas @Component e @Repository)
public class UserService {

	@Autowired     						//Marcando um ponto de injeção de dependencia no spring (fazendo a injecao  de forma transparente tbm para o progamador)
	private UserRepository repository;  //UserService depende de UserRepository (injeção de dependencias)
	
	public List<User> findAll() {     	//finAll dessa linha foi apenas o nome escolhido para esse metodo e não palavra reservada
		return repository.findAll();	//camada de servico repassando a chamada para o repository.findAll(), retorna todos os usuarios do banco de dados
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);     //"optional" pode ou nao ter um valor
		return obj.get();                                  //reotrna o objeto do tipo "User" que estiver dentro de optional
	}
	
	public User	insert(User obj) {								// retorna o usuario salvo (inserindo no banco de dados um objeto do tipo user
		return repository.save(obj);							// por padrao ja retorna o objeto salvo
	}
	
	public void delete(Long id) {									
		repository.deleteById(id);									
	}
	
	public User update(Long id, User obj) {							// id do usuario que sera deletado e User contendo os dados para ser atualizados
		User entity = repository.getOne(id);						// getOne, apenas monitora um objeto com uso do jpa
		updateData(entity, obj);									// atualiza os dados do entity, baseado nos dados que chegaram no obj
		return repository.save(entity);								// salvando no banco
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());                                // atualizando o nome do entity
		entity.setEmail(obj.getEmail());                                // atualizando o nome do Email
		entity.setPhone(obj.getPhone());                                // atualizando o nome do Phone
		
	}
	
	
}
