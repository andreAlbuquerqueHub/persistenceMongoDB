package com.fiap.lojamongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.google.common.base.Predicates;

import br.com.fiap.controller.ProdutoController;
import br.com.fiap.repository.ClienteRepository;
import br.com.fiap.repository.PedidoRepository;
import br.com.fiap.repository.ProdutoRepository;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackageClasses = ProdutoController.class)
@EnableMongoRepositories(basePackageClasses = { ClienteRepository.class, ProdutoRepository.class,
		PedidoRepository.class })
public class LojaMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaMongoApplication.class, args);
	}

	@Bean
	public Docket api() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage( "br.com.fiap.controller" ))
	        .paths(PathSelectors.any())
	        .paths(Predicates.not(PathSelectors.regex("/error.*")))
	        .build();
	}

}
