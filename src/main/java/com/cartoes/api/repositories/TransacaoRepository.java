package com.cartoes.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cartoes.api.entities.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

}
