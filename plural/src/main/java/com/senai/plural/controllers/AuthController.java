package com.senai.plural.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.plural.models.Secretario;
import com.senai.plural.security.JwtService;
import com.senai.plural.services.SecretarioService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final SecretarioService secretarioService;
    private final JwtService jwtService;

    public AuthController(
            SecretarioService secretarioService,
            JwtService jwtService) {

        this.secretarioService = secretarioService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> dados) {

        String email = dados.get("email");
        String senha = dados.get("senha");

        Secretario secretario = secretarioService.buscarPorEmail(email);

        if (secretario == null) {
            return ResponseEntity.status(401)
                    .body("Email ou senha inválidos");
        }

        if (!secretarioService.verificarSenha(
                senha,
                secretario.getSenha())) {

            return ResponseEntity.status(401)
                    .body("Email ou senha inválidos");
        }

        String token = jwtService.gerarToken(email);

        return ResponseEntity.ok(
                Map.of("token", token)
        );
    }
}