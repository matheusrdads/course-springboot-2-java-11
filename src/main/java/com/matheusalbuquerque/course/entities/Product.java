package com.matheusalbuquerque.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "tb_product")
public class Product implements Serializable {     // implements Serializable, interface que transforma os objetos em cadeias de bytes para que possam trafegar na rede e ser gravado em arquivos etc... obs será necessário informar um numero de serie padram para retirar possivel erro
	private static final long serialVersionUID = 1L; //final = constante, id obrigatório necessario para uso do serializable
	
	

	@Id //informando para o (JPA) a chave primária da tabela do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informando ao (JPA) que o campo id é auto-increment
	private Long id;
	private String name;
	private String description;
	private Double prive;
	private String imgUrl;
	
	
	// category iniciou instanciada para garantir que nao se inicie nula, mas sim vazi
	@Transient //ivita que o spring tente interpretar
	private Set<Category> categories = new HashSet<>(); //set é uma interface que representa um conjunto. garante que não haverá um produto da mesma categoria (um produto só pode ter uma categoria)

	public Product() {
	}

	public Product(Long id, String name, String description, Double prive, String imgUrl) {     //nao se coloca colecoes em construtores(ela ja foi instanciada  a cima
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.prive = prive;
		this.imgUrl = imgUrl;

	}

	public Long getId() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrive() {
		return prive;
	}

	public void setPrive(Double prive) {
		this.prive = prive;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	@Override
	public int hashCode() {
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}