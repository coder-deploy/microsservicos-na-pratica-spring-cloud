package com.coder.deploy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="produto-service")
public interface PedidoServiceProdutoInterface {

	@GetMapping("/{codigo}")
	public ResponseEntity<Object> findByCodigoFallback(@PathVariable("codigo") int codigo);	
	
}
