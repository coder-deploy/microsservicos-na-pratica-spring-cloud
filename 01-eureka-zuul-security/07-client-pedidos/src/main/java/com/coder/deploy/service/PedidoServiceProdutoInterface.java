package com.coder.deploy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coder.deploy.delegate.PedidoServiceDelegate;

@FeignClient(name="produto-service", fallback=PedidoServiceDelegate.class)
public interface PedidoServiceProdutoInterface {

	@GetMapping("/{codigo}")
	public ResponseEntity<Object> findByCodigo(@PathVariable("codigo") int codigo);	
	
}
