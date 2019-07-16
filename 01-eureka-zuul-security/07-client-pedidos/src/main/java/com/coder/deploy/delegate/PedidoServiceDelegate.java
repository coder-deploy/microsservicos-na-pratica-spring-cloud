package com.coder.deploy.delegate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.coder.deploy.dto.ErrorDTO;
import com.coder.deploy.service.PedidoServiceProdutoInterface;

@Component
public class PedidoServiceDelegate implements PedidoServiceProdutoInterface{
	
	public ResponseEntity<Object> findByCodigoFallback(int codigo) {
		ErrorDTO errorDTO = new ErrorDTO(000, "Serviço de produto indisponível!");
		return ResponseEntity.ok(errorDTO);
	}

}
