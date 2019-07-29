package com.coder.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.domain.Transacao;
import com.coder.deploy.service.TransacaoStreamService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping(value = "/api/transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoStreamService transacaoService;
	
	@Autowired
	private EurekaClient eurekaClient;
	
	private void portaClient() {
	  Application application = eurekaClient.getApplication("TRANSACOES-FINANCEIRAS-SERVICE");
	  InstanceInfo instanceInfo = application.getInstances().get(0);
	  int port = instanceInfo.getPort();
	  System.err.print("PORTA: -------------------" +port);
		//
	}
	
	
	@PostMapping()
	public ResponseEntity<Transacao> enviarTransacao(@RequestBody Transacao transacao) {
		portaClient();
		transacaoService.sendNotification(transacao);
		return ResponseEntity.ok(
				new Transacao(transacao.getData(), transacao.getValor(), transacao.getOperacao()));
	}

}
