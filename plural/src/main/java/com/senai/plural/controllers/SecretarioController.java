package com.senai.plural.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senai.plural.models.Secretario;
import com.senai.plural.services.SecretarioService;

@RestController
@RequestMapping("/secretarios")
@CrossOrigin(origins = "*")
public class SecretarioController {

    private final SecretarioService secretarioService;

    public SecretarioController(SecretarioService secretarioService) {
        this.secretarioService = secretarioService;
    }

    @PostMapping
    public ResponseEntity<Secretario> salvar(@RequestBody Secretario secretario) {
        return ResponseEntity.ok(secretarioService.salvar(secretario));
    }

    @GetMapping
    public ResponseEntity<List<Secretario>> listar() {
        return ResponseEntity.ok(
            secretarioService.listar()
        );
    }
}