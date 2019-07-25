package com.coder.deploy.domain;

import com.coder.deploy.enums.Operacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

	private String data;
	private Double valor;
	private Operacao operacao;
	
}
