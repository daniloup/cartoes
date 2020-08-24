package com.cartoes.api.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartoes.api.entities.Cartao;
import com.cartoes.api.entities.Cliente;
import com.cartoes.api.entities.Transacao;
import com.cartoes.api.repositories.CartaoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import com.cartoes.api.repositories.TransacaoRepository;
import com.cartoes.api.utils.ConsistenciaException;

@Service
public class TransacaoService {
	private static final Logger log = LoggerFactory.getLogger(TransacaoService.class);
	
	@Autowired
   	private TransacaoRepository transacaoRepository;
 
   	public Optional<Cartao> buscarPorNumero(int numero) throws ConsistenciaException {
   		log.info("Service: buscando um cartão com o número: {}", numero);
     	
     	Optional<Cartao> cartao = transacaoRepository.findByNumero(numero);
     	
     	if (!cartao.isPresent()) {

            	log.info("Service: Nenhum cartao com o número: {} foi encontrado", numero);
            	throw new ConsistenciaException("Nenhum cartão com cartão: {} foi encontrado", numero);

     	}
     	
     	return cartao;
   		
   	}

}
