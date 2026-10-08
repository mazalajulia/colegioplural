package com.senai.plural.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.plural.models.Atendimento;
import com.senai.plural.services.AtendimentoService;

@RestController
@RequestMapping("/atendimentos")
@CrossOrigin(origins = "*")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @PostMapping
    public ResponseEntity<Atendimento> salvar(@RequestBody Atendimento atendimento) {
        return ResponseEntity.ok(atendimentoService.salvar(atendimento));
    }

    @GetMapping
    public ResponseEntity<List<Atendimento>> listar() {
        return ResponseEntity.ok(atendimentoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> buscarPorId(@PathVariable Integer id) {

        Atendimento atendimento = atendimentoService.buscarPorId(id);

        if (atendimento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atendimento);
    }

    @PutMapping("/{id}/data")
    public ResponseEntity<Atendimento> atualizarData(
            @PathVariable Integer id,
            @RequestBody LocalDate novaData) {

        Atendimento atendimento = atendimentoService.atualizarData(id, novaData);

        if (atendimento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(atendimento);
    }
}
