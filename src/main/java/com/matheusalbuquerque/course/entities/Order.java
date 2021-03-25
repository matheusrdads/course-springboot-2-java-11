package com.matheusalbuquerque.course.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.matheusalbuquerque.course.entities.enums.OrderStatus;

@Entity
@Table(name = "tb_order")    //nomeando a tabela pois a palavra Order é reservada do Sql e pode dar comflito
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id     //informando para o (JPA) a chave primária da tabela do banco de dados
	@GeneratedValue(strategy = GenerationType.IDENTITY) // informando ao (JPA) que o campo id é auto-increment
	private Long id;
	
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")     //garante que o Instant sera mostrado formatado de string ISO 8601, no padrao UTC no json
	private Instant moment;     //disponivel a partir do versão 08 do java podendo subistituir o Date

	private Integer orderStatus;    //interger é um tratamenro interno da classe Order apenas para informar expicitamente ao banco de dados que será gravado um numero inteiro, externamente ainda será um OrderStatus
	
	@ManyToOne     //informando ao jpa a a relação de muitos pra um(Ordes -> User)
	@JoinColumn(name = "client_id")     //nomeando uma chave estrangeira "client_id"
	private User client;     //associação um pedido tem apenas um cliente | servirá de mapeamento na classe User

	public Order() {    //construtor padrão sem argumentos (obrigatorio no spring)
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) { //construtor recebendo atributos
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);     //atribuindo o orderstatus para o  objeto Order
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);    //orderStatus está como interge internamente na classe, aqui será convertido de numero inteiro interno da classe para orderStatus e ficar visivel no get
	}

	public void setOrderStatus(OrderStatus orderStatus) {    //prcesso inverso, recebendo um orderStatus e gravando internamente um numero inteiro com ".getCode()"
		if (orderStatus != null) {     //evitando receber valor nulo para construir o objeto
		this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
	