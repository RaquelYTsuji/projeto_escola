package com.senai.projeto_escola.application.dto;

import java.util.List;

public record ProfessorResponse(
        String id,
        String nome,
        String cpf,
        List<String> turmas,
        List<String> disciplinas
)
{}
