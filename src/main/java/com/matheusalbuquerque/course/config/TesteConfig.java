package com.matheusalbuquerque.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.matheusalbuquerque.course.entities.Category;
import com.matheusalbuquerque.course.entities.Order;
import com.matheusalbuquerque.course.entities.Product;
import com.matheusalbuquerque.course.entities.User;
import com.matheusalbuquerque.course.entities.enums.OrderStatus;
import com.matheusalbuquerque.course.repositories.CategoryRepository;
import com.matheusalbuquerque.course.repositories.OrderRepository;
import com.matheusalbuquerque.course.repositories.ProductRepository;
import com.matheusalbuquerque.course.repositories.UserRepository;

//Configuraçoes para instanciar o banco de dados

@Configuration     //informando ao spring que essa classe é especifica para configuração
@Profile("test")     // informande ao spring que é uma classe especifica para o perfilde teste em aplication.properties(o spring vai entender que é para rodar essa configuração apenas no perfil de test )
public class TesteConfig implements CommandLineRunner{     //(implements CommandLineRunner) executar assim que o programa é iniciado
	@Autowired    //permitindo que o spring resolva essa dependencia e  associe uma instancia de userRepository ao TestConfig
	private UserRepository userRepository;    //informando que um objeto depende de outro no spring (injecao de dependencias) (objeto que acessa os dados) 

	@Autowired     //permitindo que o spring resolva essa dependencia e  associe uma instancia de userRepository ao TestConfig
	private OrderRepository orderRepository;    //informando que um objeto depende de outro no spring (injecao de dependencias) (objeto que acessa os dados) 
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void run(String... args) throws Exception {    //Tudo que estiver dentro desse metodo será executado quando a aplicação iniciar
	// TODO Auto-generated method stub
		
	Category cat1 = new Category(null, "Electronics");
	Category cat2 = new Category(null, "Books");
	Category cat3 = new Category(null, "Computers"); 
	
	Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
	Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
	Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
	Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
	Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

	
	categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3)); //salvando no banco
	productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); //salvando no banco
	
		
	User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
	User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
	
	Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);     //istanciando os pedidos com padrao de hora formato utc 'Z', e associando o usuario 'u1' (foreign key na tabela order)... ao pedido 'o1'...
	Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
	Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

	userRepository.saveAll(Arrays.asList(u1, u2));     //criando uma lista e passando os objetos que seram salvos no banco
	orderRepository.saveAll(Arrays.asList(o1, o2, o3));     //salvando no banbo
	}

	
}
