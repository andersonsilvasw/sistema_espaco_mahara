package com.espacomahara.sistema.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.espacomahara.sistema.entities.Pedido;
import com.espacomahara.sistema.entities.Produto;
import com.espacomahara.sistema.entities.Usuario;
import com.espacomahara.sistema.entities.enums.FormaPagamento;
import com.espacomahara.sistema.repositories.PedidoRepository;
import com.espacomahara.sistema.repositories.ProdutoRepository;
import com.espacomahara.sistema.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Produto pro1 = new Produto(null, "Latte Viuri", "Leave in pré-escova com proteção térmica", 140.00, "");
		Produto pro2 = new Produto(null, "Monovit Pro A", "Cápsulas para crescimento capilar", 120.00, "");
		
		produtoRepository.saveAll(Arrays.asList(pro1, pro2));
		
		Usuario u1 = new Usuario(null, "Anderson Silva", "988889999", "12345"); 
		Usuario u2 = new Usuario(null, "Mara Melo", "988888888", "12345"); 
		
		Pedido ped1 = new Pedido(null, Instant.parse("2023-10-01T19:53:07Z"), FormaPagamento.CREDITO, u1);
		Pedido ped2 = new Pedido(null, Instant.parse("2023-10-02T03:42:10Z"), FormaPagamento.DEBITO, u2);
		Pedido ped3 = new Pedido(null, Instant.parse("2023-10-03T15:21:22Z"), FormaPagamento.PIX, u1);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
	}
}
