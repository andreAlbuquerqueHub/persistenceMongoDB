package br.com.fiap.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Produto {

	@Id
	private String id;
	private int codigo;
	private String descricao;
	private int quantidade;
	private Double valor;
	

	public Produto(int codigo, String descricao, int quantidade, Double valor) {
		super();
		this.codigo    = codigo;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "\ncodigo: "+ codigo + " Descricao: " + descricao + " - quantidade: " + quantidade + " - valor: " + valor ;
	}
	
}
