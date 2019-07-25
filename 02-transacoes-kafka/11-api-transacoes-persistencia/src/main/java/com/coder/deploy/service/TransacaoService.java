package com.coder.deploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.deploy.domain.Transacao;
import com.coder.deploy.repository.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public Transacao persistirTransacao(Transacao transacao) {
		return transacaoRepository.save(transacao);
	}
	
}
