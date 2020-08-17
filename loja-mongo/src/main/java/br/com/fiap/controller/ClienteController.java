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
import br.com.fiap.entity.Cliente;
import br.com.fiap.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClientes() {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			clientes = clienteRepository.findAll();

			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/clientes/{email}")
	public ResponseEntity<List<Cliente>> getClienteByEmail(@PathVariable("email") String email) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			clientes = clienteRepository.findByEmail(email);

			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> postCliente(@RequestBody Cliente cliente) {
		try {

			clienteRepository.save(cliente);

			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/clientes")
	public ResponseEntity<Cliente> putCliente(@RequestBody Cliente cliente) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			clientes = clienteRepository.findByEmail(cliente.getEmail());

			if (clientes.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				cliente.setId(clientes.get(0).getId());
				clienteRepository.save(cliente);
			}

			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/clientes/{email}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable("email") String email) {
		try {
			List<Cliente> clientes = new ArrayList<Cliente>();

			clientes = clienteRepository.findByEmail(email);

			if (clientes.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				clienteRepository.delete(clientes.get(0));
			}

			return new ResponseEntity<>(null, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
