package com.coder.deploy.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.coder.deploy.domain.Produto;

@Service
public class ProdutoService {
	
	private static final List<Produto> produtos = Arrays.asList(new Produto(175, "Notebook Samsung Essentials E20", 1599.99),
			new Produto(176, "Notebook Samsung Expert X40 5ª Geração", 2899.99),
			new Produto(177, "Notebook Acer E5-553G-T4TJ", 1859.79),
			new Produto(178, "Notebook Vivobook X510UR-BQ291T", 3189.86),
			new Produto(179, "Notebook Ultraportátil Dell XPs-9380-m30r 8ª Geração", 13389.00),
			new Produto(180, "Notebook Lenovo Gamer Legion Y530", 4889.00));
	
	public List<Produto> findAll() {
		return produtos;
	}
	
	public Optional<Produto> findById(int codigo) {
		Predicate<Produto> busca = p -> p.getCodigo() == codigo;
		return produtos.stream().filter(busca).findFirst();
	}

}
