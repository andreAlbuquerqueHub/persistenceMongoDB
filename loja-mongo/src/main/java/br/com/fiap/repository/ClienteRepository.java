package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.fiap.entity.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String>{

	public List<Cliente> findByEmail(String email);
	
}
