package com.coder.deploy.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coder.deploy.dto.ProdutoDTO;

@FeignClient(name="produto-service")
public interface PedidoServiceProdutoInterface {

	@GetMapping("/{codigo}")
	public ProdutoDTO findByCodigo(@PathVariable("codigo") int codigo);
	
}
