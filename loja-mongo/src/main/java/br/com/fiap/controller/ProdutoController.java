package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.entity.Produto;
import br.com.fiap.repository.ProdutoRepository;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public ResponseEntity<List<Produto>> getAllProdutos() {
		try {
			List<Produto> produtos = new ArrayList<Produto>();

			produtos = produtoRepository.findAll();

			return new ResponseEntity<>(produtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/produtos/{codigo}")
	public ResponseEntity<List<Produto>> getProdutoByCodigo(@PathVariable("codigo") int codigo) {
		try {
			List<Produto> produtos = new ArrayList<Produto>();

			produtos = produtoRepository.findByCodigo(codigo);

			return new ResponseEntity<>(produtos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/produtos")
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		try {

			produtoRepository.save(produto);

			return new ResponseEntity<>(produto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/produtos")
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {
		try {

			List<Produto> produtos = new ArrayList<Produto>();

			produtos = produtoRepository.findByCodigo(produto.getCodigo());

			if (produtos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				produto.setId(produtos.get(0).getId());
				produtoRepository.save(produto);
			}

			return new ResponseEntity<>(produto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/produtos/{codigo}")
	public ResponseEntity<List<Produto>> deleteProduto(@PathVariable("codigo") int codigo) {
		try {
			List<Produto> produtos = new ArrayList<Produto>();

			produtos = produtoRepository.findByCodigo(codigo);

			if (produtos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				produtoRepository.delete(produtos.get(0));
			}

			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
