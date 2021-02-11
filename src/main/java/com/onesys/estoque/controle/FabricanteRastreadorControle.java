package com.onesys.estoque.controle;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesys.estoque.evento.RecursoCriadoEvent;
import com.onesys.estoque.model.FabricanteRastreador;
import com.onesys.estoque.repositorio.FabricanteRastreadorRepositorio;
import com.onesys.estoque.servico.FabricanteRastreadorServico;


@RestController
@RequestMapping("/fabricantesRastreador")
public class FabricanteRastreadorControle {
	
	@Autowired	
	private FabricanteRastreadorRepositorio fabricanteRepositorio;
	@Autowired
	private FabricanteRastreadorServico fabricanteServico;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<FabricanteRastreador> salvar(@Valid @RequestBody FabricanteRastreador fabricanteRastreador, HttpServletResponse response) {
		fabricanteServico.salvarFabricante(fabricanteRastreador);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, fabricanteRastreador.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteRastreador);
	}
	
}
