package com.coder.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.domain.Transacao;
import com.coder.deploy.service.TransacaoStreamService;

@RestController
@RequestMapping(value = "/api/transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoStreamService transacaoService;
	
	@PostMapping()
	public ResponseEntity<Transacao> enviarTransacao(@RequestBody Transacao transacao) {
		transacaoService.sendNotification(transacao);
		return ResponseEntity.ok(
				new Transacao(transacao.getData(), transacao.getValor(), transacao.getOperacao()));
	}

}
