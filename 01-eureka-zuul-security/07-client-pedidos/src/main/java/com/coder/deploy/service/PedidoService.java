package com.coder.deploy.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.coder.deploy.dto.ProdutoDTO;
import com.coder.deploy.model.Pedido;


@Service
public class PedidoService {

	public List<Pedido> pedidos = Arrays.asList(new Pedido(25111, "2019-06-17", 
			Arrays.asList(new ProdutoDTO(175, "Notebook Samsung Essentials E20", 1599.99),
					new ProdutoDTO(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99),
					new ProdutoDTO(177, "Notebook Acer E5-553G-T4TJ", 1859.79),
					new ProdutoDTO(178, "Notebook Samsung Expert X40 5ª Geração", 2899.99),
					new ProdutoDTO(180, "Notebook Lenovo Gamer Legion Y530", 4889.00))),
			new Pedido(42127, "2019-06-18", Arrays.asList(new ProdutoDTO(179, "Notebook Ultraportátil Dell XPs-9380-m30r 8ª Geração", 13389.00),
					new ProdutoDTO(180, "Notebook Lenovo Gamer Legion Y530", 4889.00),
					new ProdutoDTO(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99))),
			new Pedido(39779, "2019-06-18", Arrays.asList(new ProdutoDTO(177, "Notebook Acer E5-553G-T4TJ", 1859.79),
					new ProdutoDTO(175, "Notebook Samsung Essentials E20", 1599.99),
					new ProdutoDTO(179, "Notebook Ultraportátil Dell XPs-9380-m30r 8ª Geração", 13389.00))),
			new Pedido(52299, "2019-06-19", Arrays.asList(new ProdutoDTO(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99),
					new ProdutoDTO(180, "Notebook Lenovo Gamer Legion Y530", 4889.00))));
	
	public List<Pedido> findAll() {
		return pedidos;
	}
	
	public Optional<Pedido> findPedidoById(int numero) {
		Predicate<Pedido> busca = p -> p.getNumero() == numero;
		return pedidos.stream().filter(busca).findFirst();
	}
	
}
