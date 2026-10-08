package com.senai.plural.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.senai.plural.models.Atendimento;
import com.senai.plural.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public Atendimento salvar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listar() {
        return atendimentoRepository.findAllByOrderByDataAsc();
    }

    public Atendimento buscarPorId(Integer id) {
        return atendimentoRepository.findById(id).orElse(null);
    }

    public Atendimento atualizarData(Integer id, LocalDate novaData) {

        Atendimento atendimento = atendimentoRepository.findById(id).orElse(null);

        if (atendimento != null) {
            atendimento.setData(novaData);
            return atendimentoRepository.save(atendimento);
        }

        return null;
    }
}