package com.coder.deploy.model;

import java.util.List;

import com.coder.deploy.dto.ProdutoDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {

	private long numero;
	private String data;
	private List<ProdutoDTO> produtos;
	
	
}
