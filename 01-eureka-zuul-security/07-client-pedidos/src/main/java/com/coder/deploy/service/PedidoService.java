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
		List<ProdutoDTO> produtosPedido25111 = new ArrayList<>();
		List<ProdutoDTO> produtosPedido42127 = new ArrayList<>();
		List<ProdutoDTO> produtosPedido39779 = new ArrayList<>();
		List<ProdutoDTO> produtosPedido52299 = new ArrayList<>();
		
		produtosPedido25111.add(new ProdutoDTO(175, "Notebook Samsung Essentials E20", 1599.99));
		produtosPedido25111.add(new ProdutoDTO(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99));
		produtosPedido25111.add(new ProdutoDTO(177, "Notebook Acer E5-553G-T4TJ", 1859.79));
		produtosPedido25111.add(new ProdutoDTO(178, "Notebook Samsung Expert X40 5ª Geração", 2899.99));
		produtosPedido25111.add(new ProdutoDTO(179, "Notebook Ultraportátil Dell XPs-9380-m30r 8ª Geração", 13389.00));
		produtosPedido25111.add(new ProdutoDTO(180, "Notebook Lenovo Gamer Legion Y530", 4889.00));
		
		produtosPedido42127.add(new ProdutoDTO(179, "Notebook Ultraportátil Dell XPs-9380-m30r 8ª Geração", 13389.00));
		produtosPedido42127.add(new ProdutoDTO(180, "Notebook Lenovo Gamer Legion Y530", 4889.00));
		
		produtosPedido39779.add(new ProdutoDTO(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99));
		produtosPedido39779.add(new ProdutoDTO(177, "Notebook Acer E5-553G-T4TJ", 1859.79));
		produtosPedido39779.add(new ProdutoDTO(175, "Notebook Samsung Essentials E20", 1599.99));
		
		produtosPedido52299.add(new ProdutoDTO(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99));
		produtosPedido52299.add(new ProdutoDTO(180, "Notebook Lenovo Gamer Legion Y530", 4889.00));
		
		pedidos.stream().forEach(i -> {
			if (i.getNumero() == 25111) {
				i.setProdutos(produtosPedido25111);
			} else if (i.getNumero() == 42127) {
				i.setProdutos(produtosPedido42127);
			} else if (i.getNumero() == 42127) {
				i.setProdutos(produtosPedido42127);
			} else if (i.getNumero() == 25111) {
				i.setProdutos(produtosPedido25111);
			} else if (i.getNumero() == 52299) {
				i.setProdutos(produtosPedido52299);
			}
		});		
		return pedidos;
	}
	
	public Optional<Pedido> findById(int codigo) {
		Predicate<Pedido> busca = p -> p.getNumero() == codigo;
		return pedidos.stream().filter(busca).findFirst();
	}
	
}
