package com.senai.plural.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.plural.models.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {

    List<Responsavel> findByNomeContainingIgnoreCase(String nome);

}
