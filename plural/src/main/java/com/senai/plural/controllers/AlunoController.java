package com.senai.plural.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.plural.models.Aluno;
import com.senai.plural.services.AlunoService;

@RestController
@RequestMapping("/alunos")
@CrossOrigin(origins = "*")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.salvar(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        return ResponseEntity.ok(alunoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {

        Aluno aluno = alunoService.buscarPorId(id);

        if (aluno == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(aluno);
    }
}