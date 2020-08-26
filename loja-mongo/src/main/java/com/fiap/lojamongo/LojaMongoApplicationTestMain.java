package com.fiap.lojamongo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;
import br.com.fiap.entity.ProdutosPedido;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.repository.ProdutoRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = { ClienteRepository.class, ProdutoRepository.class,
		PedidoRepository.class })
public class LojaMongoApplicationTestMain implements CommandLineRunner {

	@Autowired
	public ClienteRepository clienteRepository;

	@Autowired
	public ProdutoRepository produtoRepository;

	@Autowired
	public PedidoRepository pedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LojaMongoApplicationTestMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.test(args);
	}

	public void test(String... args) throws Exception {
		clienteRepository.deleteAll();
		produtoRepository.deleteAll();
		pedidoRepository.deleteAll();
		List<Endereco> enderecos = new ArrayList<>();

		Endereco residencial1 = new Endereco(1, "Rua Jose Caetano", "São Paulo", "SP", "123456789");
		Endereco residencial2 = new Endereco(2, "Avenida Silva Santos", "São Paulo", "SP", "987654321");
		enderecos.add(residencial1);
		enderecos.add(residencial2);

		Cliente cliente = new Cliente("Eduarda Alana Duarte", "eduardaalanaduarte-99@grupova.com.br", "89609897460",
				enderecos);

		clienteRepository.save(cliente);
		enderecos.clear();

		residencial1 = new Endereco(1, "Avenida Candeias", "Ariquemes", "RO", "76871247");
		enderecos.add(residencial1);

		cliente = new Cliente("Alice Flávia da Cunha", "aliceflaviadacunha..aliceflaviadacunha@gmailo.com",
				"77106766003", enderecos);

		clienteRepository.save(cliente);

		// Busca todos os clientes
		System.out.println("Todos os clientes:");
		System.out.println(clienteRepository.findAll());
		System.out.println("\n");

		// Adiona produtos na base de dados
		Produto produto1 = new Produto(1, "Iphone", 100, 2999.99);
		Produto produto2 = new Produto(2, "Geladeira", 8, 899.99);
		Produto produto3 = new Produto(3, "Fogão", 8, 474.05);
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		produtoRepository.save(produto3);

		// Lista todos os produtos na base
		System.out.println("Todos os produtos");
		System.out.println(produtoRepository.findAll());
		System.out.println("\n");

		// Cria pedido - 1
		ProdutosPedido produtosPedido = new ProdutosPedido(1, 1);
		List<ProdutosPedido> lista = new ArrayList<ProdutosPedido>();
		;
		lista.add(produtosPedido);
		Pedido pedido = new Pedido(25002, "eduardaalanaduarte-99@grupova.com.br", lista);
		pedidoRepository.save(pedido);
		lista.clear();

		// Cria pedido - 2
		produtosPedido = new ProdutosPedido(2, 1);
		lista.add(produtosPedido);
		produtosPedido = new ProdutosPedido(3, 1);
		lista.add(produtosPedido);
		pedido = new Pedido(25003, "aliceflaviadacunha..aliceflaviadacunha@gmailo.com", lista);
		pedidoRepository.save(pedido);

		// Listar todos os pedidos
		System.out.println("Todos os pedidos");
		System.out.println(pedidoRepository.findAll());
		System.out.println("\n");

	}

}
