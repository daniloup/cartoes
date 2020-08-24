package com.cartoes.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cartoes.api.entities.Cartao;
import com.cartoes.api.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
	
	@Transactional(readOnly = true)
   	Cartao findByNumero(int numero);

}
