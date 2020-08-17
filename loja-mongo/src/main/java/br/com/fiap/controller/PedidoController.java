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

import br.com.fiap.entity.Pedido;
import br.com.fiap.repository.PedidoRepository;

@RestController
public class PedidoController {

	@Autowired
	PedidoRepository pedidoRepository;

	@GetMapping("/pedidos")
	public ResponseEntity<List<Pedido>> getAllPedidos() {
		try {
			List<Pedido> pedidos = new ArrayList<Pedido>();

			pedidos = pedidoRepository.findAll();

			return new ResponseEntity<>(pedidos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pedidos/{codigo}")
	public ResponseEntity<List<Pedido>> getPedidoByCodigo(@PathVariable("codigo") int codigo) {
		try {
			List<Pedido> pedidos = new ArrayList<Pedido>();

			pedidos = pedidoRepository.findByCodigo(codigo);

			return new ResponseEntity<>(pedidos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/pedidos")
	public ResponseEntity<Pedido> postPedido(@RequestBody Pedido pedido) {
		try {

			pedidoRepository.save(pedido);

			return new ResponseEntity<>(pedido, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/pedidos")
	public ResponseEntity<Pedido> putPedido(@RequestBody Pedido pedido) {
		try {

			List<Pedido> pedidos = new ArrayList<Pedido>();

			pedidos = pedidoRepository.findByCodigo(pedido.getCodigo());

			if (pedidos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				pedido.setId(pedidos.get(0).getId());
				pedidoRepository.save(pedido);
			}

			return new ResponseEntity<>(pedido, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/pedidos/{codigo}")
	public ResponseEntity<List<Pedido>> deletePedido(@PathVariable("codigo") int codigo) {
		try {
			List<Pedido> pedidos = new ArrayList<Pedido>();

			pedidos = pedidoRepository.findByCodigo(codigo);

			if (pedidos.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				pedidoRepository.delete(pedidos.get(0));
			}

			return new ResponseEntity<>(pedidos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
