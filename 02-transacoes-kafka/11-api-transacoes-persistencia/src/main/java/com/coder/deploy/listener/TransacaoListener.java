package com.coder.deploy.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.coder.deploy.domain.Transacao;
import com.coder.deploy.service.TransacaoService;
import com.coder.deploy.streams.TransacaoStreams;

@Component
public class TransacaoListener {
	
	@Autowired
	private TransacaoService transacaoService;
	
	@StreamListener(TransacaoStreams.INPUT)
	public void sendMailNotification(@Payload Transacao transacao) {
		transacaoService.persistirTransacao(transacao);
	}
}
