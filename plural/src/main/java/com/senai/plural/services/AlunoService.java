package com.senai.plural.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.plural.models.Aluno;
import com.senai.plural.repositories.AlunoRepository;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }
}
