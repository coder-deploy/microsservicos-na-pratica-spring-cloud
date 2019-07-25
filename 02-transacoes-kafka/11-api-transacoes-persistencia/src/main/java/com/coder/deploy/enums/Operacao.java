package com.coder.deploy.enums;

public enum Operacao {

	ENTRADA("E"),
	SAIDA("S");
	
	private String valor;
	
	Operacao(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
}
