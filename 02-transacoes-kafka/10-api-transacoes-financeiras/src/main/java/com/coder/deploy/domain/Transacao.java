package com.coder.deploy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

	private String data;
	private Double valor;
	private String operacao;
	
}
