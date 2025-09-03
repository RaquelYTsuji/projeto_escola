package com.senai.projeto_escola.application.dto;

public record AlunoRequest(
        String nome,
        String cpf,
        String curso,
        String turma
)
{}
