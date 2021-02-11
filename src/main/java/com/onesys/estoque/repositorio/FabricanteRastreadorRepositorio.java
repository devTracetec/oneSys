package com.onesys.estoque.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onesys.estoque.model.FabricanteRastreador;

@Repository
public interface FabricanteRastreadorRepositorio extends JpaRepository<FabricanteRastreador, Long>{
	
}
