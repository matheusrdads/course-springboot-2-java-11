package com.matheusalbuquerque.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusalbuquerque.course.entities.User;
import com.matheusalbuquerque.course.repositories.UserRepository;

//Configuraçoes para instanciar o banco de dados

@Configuration//informando ao spring que essa classe é especifica para configuração
@Profile("test")// informande ao spring que é uma classe especifica para o perfilde teste em aplication.properties(o spring vai entender que é para rodar essa configuração apenas no perfil de test )
public class TesteConfig implements CommandLineRunner{ //(implements CommandLineRunner) executar assim que o programa é iniciado
	@Autowired //permitindo que o spring resolva essa dependencia e  associe uma instancia de userRepository ao TestConfig
	private UserRepository userRepository; //informando que um objeto depende de outro no spring (injecao de dependencias) (objeto que acessa os dados) 

@Override
public void run(String... args) throws Exception { //Tudo que estiver dentro desse metodo será executado quando a aplicação iniciar
	// TODO Auto-generated method stub
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

	userRepository.saveAll(Arrays.asList(u1, u2));  //criando uma lista e passando os objetos que seram salvos no banco
}

	
}