package com.coder.deploy.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="produto-service")
public interface PedidoServiceProdutoInterface {

	//@GetMapping("/todos")
	
}
