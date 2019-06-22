package com.coder.deploy.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.coder.deploy.dto.ProdutoDTO;
import com.coder.deploy.model.Pedido;


@Service
public class PedidoService {

	private List<ProdutoDTO> lista = new ArrayList<>();
	private List<Pedido> pedidos = Arrays.asList(new Pedido(25111, "2019-06-17", lista),
			new Pedido(42127, "2019-06-18", lista),
			new Pedido(39779, "2019-06-18", lista),
			new Pedido(52299, "2019-06-19", lista));
	
	public List<Pedido> findAll() {
		return pedidos;
	}
	
	public Optional<Pedido> findById(int codigo) {
		Predicate<Pedido> busca = p -> p.getNumero() == codigo;
		return pedidos.stream().filter(busca).findFirst();
	}
	
}
