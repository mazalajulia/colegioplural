package com.senai.plural.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.plural.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {

    List<Atendimento> findAllByOrderByDataAsc();

}
