package com.espacomahara.sistema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espacomahara.sistema.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
