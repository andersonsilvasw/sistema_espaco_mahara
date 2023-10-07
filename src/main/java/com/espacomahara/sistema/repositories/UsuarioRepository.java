package com.espacomahara.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espacomahara.sistema.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
