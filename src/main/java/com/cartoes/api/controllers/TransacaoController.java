package com.cartoes.api.controllers;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cartoes.api.entities.Cliente;
import com.cartoes.api.services.ClienteService;
import com.cartoes.api.utils.ConsistenciaException;

@RestController
@RequestMapping("/api/transacao")
@CrossOrigin(origins = "*")
public class TransacaoController {
	private static final Logger log = LoggerFactory.getLogger(TransacaoController.class);
	@Autowired
	private TransacaoService transacaoService;
	
	public ResponseEntity<Transacao> buscarPorId(@PathVariable("id") int id) {
		try {
			log.info("Controller: buscando transacao com id: {}", id);

			Optional<Transacao> transacao = transacaoService.buscarPorId(id);
			return ResponseEntity.ok(transacao.get());
		} catch (ConsistenciaException e) {
			log.info("Controller: Inconsistência de dados: {}", e.getMessage());
			return ResponseEntity.badRequest().body(new Cliente());
		} catch (Exception e) {
			log.error("Controller: Ocorreu um erro na aplicação: {}", e.getMessage());
			return ResponseEntity.status(500).body(new Cliente());
		}
	}
	
	@GetMapping(value = "/data_Transacao/{data_Transacao}")
	public ResponseEntity<Transacao> buscarPordata_Transacao(@PathVariable("data_Transacao") String Date) {
		try {
			log.info("Controller: buscando DATA TRANSACAO: {}", data_Transacao);
			Optional<Transacao> cliente = transacaoService.buscarPorCpf(data_Transacao);
			return ResponseEntity.ok(transacao.get());
		} catch (ConsistenciaException e) {
			log.info("Controller: Cartao Vencido: {}", e.getMessage());
			return ResponseEntity.badRequest().body(new Transacao());
		} catch (Exception e) {
			log.error("Controller: Ocorreu um erro na aplicação: {}", e.getMessage());
			return ResponseEntity.status(500).body(new Transacao());
		}
	}
