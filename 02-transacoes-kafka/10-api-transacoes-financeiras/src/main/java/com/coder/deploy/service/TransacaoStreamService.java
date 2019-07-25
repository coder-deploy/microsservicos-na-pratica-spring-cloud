package com.coder.deploy.service;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.coder.deploy.domain.Transacao;
import com.coder.deploy.streams.TransacaoStreams;

@Service
public class TransacaoStreamService {

	private final TransacaoStreams transacaoStreams;

	public TransacaoStreamService(TransacaoStreams transacaoStreams) {
		super();
		this.transacaoStreams = transacaoStreams;
	}
	
	public void sendNotification(final Transacao transacao) {
		MessageChannel messageChannel = transacaoStreams.notifyTo();
		messageChannel.send(MessageBuilder.withPayload(transacao)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
				.build());
	}
}
