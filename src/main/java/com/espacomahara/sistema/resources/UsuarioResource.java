package com.espacomahara.sistema.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espacomahara.sistema.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll () {
		Usuario u = new Usuario(1L, "Anderson", "anderson@gmail.com", "123456");
		return ResponseEntity.ok().body(u);
	}
}
