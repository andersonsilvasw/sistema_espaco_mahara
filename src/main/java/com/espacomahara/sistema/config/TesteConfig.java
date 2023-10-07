package com.espacomahara.sistema.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.espacomahara.sistema.entities.Pedido;
import com.espacomahara.sistema.entities.Usuario;
import com.espacomahara.sistema.repositories.PedidoRepository;
import com.espacomahara.sistema.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Anderson Silva", "988889999", "12345"); 
		Usuario u2 = new Usuario(null, "Mara Melo", "988888888", "12345"); 
		
		Pedido p1 = new Pedido(null, Instant.parse("2023-10-01T19:53:07Z"), u1);
		Pedido p2 = new Pedido(null, Instant.parse("2023-10-02T03:42:10Z"), u2);
		Pedido p3 = new Pedido(null, Instant.parse("2023-10-03T15:21:22Z"), u1);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
