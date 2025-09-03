package com.senai.projeto_escola.application.dto;

import java.util.List;

public record ProfessorRequest(
        String nome,
        String cpf,
        List<String> turmas,
        List<String> disciplinas
)
{}
