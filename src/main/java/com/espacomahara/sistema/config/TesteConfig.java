package com.espacomahara.sistema.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.espacomahara.sistema.entities.Usuario;
import com.espacomahara.sistema.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Anderson Silva", "988889999", "12345"); 
		Usuario u2 = new Usuario(null, "Mara Melo", "988888888", "12345"); 
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}
}
