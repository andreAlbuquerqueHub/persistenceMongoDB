package br.com.fiap.entity;

import lombok.Data;

@Data
public class ProdutosPedido  {

	private int codigo;
	private int quantidade;
	
	
	public ProdutosPedido(int codigo, int quantidade) {
		super();
		this.codigo    = codigo;
		this.quantidade = quantidade;
	}
	
}
