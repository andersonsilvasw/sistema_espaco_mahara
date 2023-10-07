package com.espacomahara.sistema.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.espacomahara.sistema.entities.enums.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;
	
	private Integer formaPagamento;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;
	
	public Pedido() {
	}

	public Pedido(Long id, Instant data, FormaPagamento formaPagamento, Usuario cliente) {
		super();
		this.id = id;
		this.data = data;
		setFormaPagamento(formaPagamento);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}
	
	public FormaPagamento getFormaPagamento() {
		return FormaPagamento.valueOf(formaPagamento);
	}
	
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		if (formaPagamento != null) {
			this.formaPagamento = formaPagamento.getCode();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
}
