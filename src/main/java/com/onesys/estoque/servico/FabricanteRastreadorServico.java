package com.onesys.estoque.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onesys.estoque.model.FabricanteRastreador;
import com.onesys.estoque.repositorio.FabricanteRastreadorRepositorio;

@Service
public class FabricanteRastreadorServico {
	
	@Autowired
	private FabricanteRastreadorRepositorio fabricanteRastreadorRepositorio; 
	
	
	public void salvarFabricante (FabricanteRastreador fabricanteRastreador) {
		fabricanteRastreador.setAtivo(true);
		fabricanteRastreadorRepositorio.save(fabricanteRastreador);
	}
	
}
