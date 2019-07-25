package com.coder.deploy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.deploy.domain.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
