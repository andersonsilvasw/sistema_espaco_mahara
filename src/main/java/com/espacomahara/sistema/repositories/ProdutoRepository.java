package com.espacomahara.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espacomahara.sistema.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
