package com.senai.plural.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.plural.models.Secretario;

public interface SecretarioRepository extends JpaRepository<Secretario, Integer> {

    Optional<Secretario> findByEmail(String email);

}