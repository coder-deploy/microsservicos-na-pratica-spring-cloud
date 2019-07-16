package com.coder.deploy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.delegate.PedidoServiceDelegate;
import com.coder.deploy.model.Pedido;
import com.coder.deploy.service.PedidoService;
import com.coder.deploy.service.PedidoServiceProdutoInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController()
public class PedidoController extends PedidoServiceDelegate{

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private PedidoServiceProdutoInterface pedidoProdutoService;
	
	@GetMapping()
	public List<Pedido> findAll(){
		return pedidoService.findAll();
	}
	
	@GetMapping("/{numero}")
	public ResponseEntity<Optional<Pedido>> findByCodigo(@PathVariable("numero") int codigo) {
		return ResponseEntity.ok(pedidoService.findById(codigo));
	}
	
	@GetMapping("/produto/{codigo}")
	@HystrixCommand(fallbackMethod = "findByCodigoFallback")
	public ResponseEntity<Object> findAll(@PathVariable("codigo") int codigo){
		return pedidoProdutoService.findByCodigoFallback(codigo);
	}
	
	
}
