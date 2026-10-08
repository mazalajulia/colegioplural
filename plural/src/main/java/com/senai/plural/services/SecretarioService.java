package com.senai.plural.services;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.plural.models.Secretario;
import com.senai.plural.repositories.SecretarioRepository;

@Service
public class SecretarioService {

    private final SecretarioRepository secretarioRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public SecretarioService(SecretarioRepository secretarioRepository) {
        this.secretarioRepository = secretarioRepository;
    }

    public Secretario buscarPorEmail(String email) {
        return secretarioRepository.findByEmail(email).orElse(null);
    }

    public Secretario salvar(Secretario secretario) {

        secretario.setSenha(
            encoder.encode(secretario.getSenha())
        );

        return secretarioRepository.save(secretario);
    }

    public boolean verificarSenha(String senha, String senhaCriptografada) {
        return encoder.matches(senha, senhaCriptografada);
    }

    public List<Secretario> listar() {
    return secretarioRepository.findAll();
}
}