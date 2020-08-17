package br.com.fiap.entity;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
public class Endereco {

	@Id
	private String id;
	private int codigo;
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	
	@Override
	public String toString() {
		return "\n" + rua + " - estado: " + estado + " - cidade: " + cidade + " - cep: " + cep;
	}

	public Endereco() {
		super();
	}

	public Endereco(int codigo, String rua, String cidade, String estado, String cep) {
		super();
		this.codigo = codigo;
		this.rua 	= rua;
		this.cidade = cidade;
		this.cep	= cep;
		this.estado = estado;
	}

}
