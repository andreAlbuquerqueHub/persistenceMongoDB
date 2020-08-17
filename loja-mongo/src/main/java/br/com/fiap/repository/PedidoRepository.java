package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.entity.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

	public List<Pedido> findByCodigo(int codigo);
}
