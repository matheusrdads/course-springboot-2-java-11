package com.matheusalbuquerque.course.entities.enums;

//tipo enumerado
public enum OrderStatus {
	
	WAITING_PAYMENT(1),     //cada atributo recenbendo um identificador que será amarzenando no campo no banco de dados (x)
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;     //codigo do tipo enumerado
	
	private OrderStatus(int code) {     //construtor do codigo tipo enumerado, atentar que seu tipo é "private". Recebendo code como parametro externemente
		this.code = code;
	}
	
	public int getCode(){//deixando o "code" acessivel ao mundo exterior
		return code;
	}
	public static OrderStatus valueOf(int code){     //convertendo valor numérico para valor enumerado (static por que esse metodo funciona sem  precisar instanciar). retorna o codigo estatico do atributo
		for (OrderStatus value : OrderStatus.values()) {     //percorrendo todos os valores possiveis de OrderStatus 
			if(value.getCode() == code) {
				return value;
			}
		}
			throw new IllegalArgumentException("Invalid OrderStatus code");    //exceção para code recebido invalido
	}
}
