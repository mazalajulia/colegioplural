package com.senai.plural.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.plural.models.Responsavel;
import com.senai.plural.repositories.ResponsavelRepository;

@Service
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    public ResponsavelService(ResponsavelRepository responsavelRepository) {
        this.responsavelRepository = responsavelRepository;
    }

    public Responsavel salvar(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public List<Responsavel> listar() {
        return responsavelRepository.findAll();
    }

    public Responsavel buscarPorId(Integer id) {
        return responsavelRepository.findById(id).orElse(null);
    }

    public List<Responsavel> buscarPorNome(String nome) {
    return responsavelRepository.findByNomeContainingIgnoreCase(nome);
}
}