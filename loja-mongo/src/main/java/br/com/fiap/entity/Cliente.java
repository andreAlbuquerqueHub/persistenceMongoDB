package br.com.fiap.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document
public class Cliente {

	@Id
	private String id;
	private String nome;
	@Field("email")@Indexed(unique = true)
	private String email;
	private String cpf;
	private List<Endereco> endereco;
	

	public Cliente(String nome, String email, String cpf, List<Endereco> endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + " - CPF: " + cpf + " - Email: " + email + "\nEndereco: " + endereco;
	}

}
