package com.matheusalbuquerque.course.entities;

import java.io.Serializable;

public class User implements Serializable { // implements Serializable, interface que transforma os objetos em cadeias de bytes para que possam trafegar na rede e ser gravado em arquivos etc... obs será necessário informar um numero de serie padram para retirar possivel erro
	
	private static final long serialVersionUID = 1L; //final = constante, id obrigatório necessario para uso do serializable
	
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() { //construtor vazio obrigatório quando se usa o spring boot
		
	}

	public User(Long id, String name, String email, String phone, String password) { // construtor recebendo todos os atributos da classe User
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() { //getters e setters. métodos especializados em dar um acesso controlado aos atributos | get, retorna o conteudo do atributo e set permite sua alteração
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() { // hashCode e equals, critério de comparação entre objetos e tabelha Hash (apenas o atributo "id" foi usado como parametro nesse exemplo)
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
