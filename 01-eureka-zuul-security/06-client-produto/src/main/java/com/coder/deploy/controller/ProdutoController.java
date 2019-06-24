package com.coder.deploy.controller;

import java.io.UnsupportedEncodingException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coder.deploy.domain.Produto;
import com.coder.deploy.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping()
	public ResponseEntity<List<Produto>> findAll() throws AccessDeniedException, UnsupportedEncodingException {
		return ResponseEntity.ok(produtoService.findAll());
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Produto>> findByCodigo(@PathVariable("codigo") int codigo) {
		return ResponseEntity.ok(produtoService.findById(codigo));
	}
	
}
