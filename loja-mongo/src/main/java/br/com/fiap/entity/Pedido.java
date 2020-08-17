package br.com.fiap.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Pedido {
	
	@Id
	private String id;
	@Indexed(unique = true)
	private int codigo;
	private String emailCliente;
	private int codigoEnderecoEntrega;
	private List<ProdutosPedido> produto;
	
	
	public Pedido(int codigo, String emailCliente, List<ProdutosPedido> produto) {
		this.codigo = codigo;
	    this.emailCliente = emailCliente;
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "\ncodigo: "+ codigo + " Email do cliente: " + emailCliente + " - Produtos: " + produto ;
	}
	

}
