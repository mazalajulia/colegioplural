package com.senai.plural.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.plural.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
