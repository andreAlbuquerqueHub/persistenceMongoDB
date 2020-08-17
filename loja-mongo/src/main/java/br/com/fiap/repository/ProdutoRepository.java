package br.com.fiap.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import br.com.fiap.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String>{

	public List<Produto> findByCodigo(int codigo);
	
	@Query("{ 'codigo' : { $gte: ?0, $lte: ?1 } }")
	public List<Produto> findByCodigoBetween(int min, int max);
	
	
}
