package com.senai.projeto_escola.interface_ui.controller.dto;

import com.senai.projeto_escola.domain.entity.Curso;

public record AlunoRequest(
        String nome,
        String cpf,
        String curso,
        String turma
)
{}
