package com.senai.projeto_escola.interface_ui.controller.dto;

import java.util.List;

public record ProfessorRequest(
        String nome,
        String cpf,
        List<String> turmas,
        List<String> disciplinas
)
{}
