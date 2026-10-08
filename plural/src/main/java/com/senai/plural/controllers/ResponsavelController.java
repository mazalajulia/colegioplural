package com.senai.plural.controllers;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.senai.plural.models.Responsavel;
import com.senai.plural.services.ResponsavelService;

@RestController
@RequestMapping("/responsaveis")
@CrossOrigin(origins = "*")
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    public ResponsavelController(ResponsavelService responsavelService) {
        this.responsavelService = responsavelService;
    }

    @PostMapping
    public ResponseEntity<Responsavel> salvar(@RequestBody Responsavel responsavel) {
        return ResponseEntity.ok(responsavelService.salvar(responsavel));
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> listar() {
        return ResponseEntity.ok(responsavelService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscarPorId(@PathVariable Integer id) {

        Responsavel responsavel = responsavelService.buscarPorId(id);

        if (responsavel == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(responsavel);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Responsavel>> buscar(@RequestParam String nome) {
        return ResponseEntity.ok(responsavelService.buscarPorNome(nome));
}
}