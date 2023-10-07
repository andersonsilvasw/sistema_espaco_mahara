package com.espacomahara.sistema.entities.enums;

public enum FormaPagamento {
	
	DINHEIRO(1),
	CREDITO(2),
	DEBITO(3),
	PIX(4),
	AGUARDANDO_PAGAMENTO(5);

	private int code;
	
	private FormaPagamento(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static FormaPagamento valueOf(int code) {
		for (FormaPagamento value : FormaPagamento.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código da forma de pagamento Inválida");
	}
}
