package com.senai.plural.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "horario")
    private LocalTime horario;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "secretario_id")
    private Secretario secretario;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    public Atendimento() {
    }

    public Atendimento(Aluno aluno, LocalDate data, String descricao, LocalTime horario, Integer id, Secretario secretario) {
        this.aluno = aluno;
        this.data = data;
        this.descricao = descricao;
        this.horario = horario;
        this.id = id;
        this.secretario = secretario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Secretario getSecretario() {
        return secretario;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    
    }