package com.senai.projeto_escola.interface_ui.controller.dto;

import com.senai.projeto_escola.domain.entity.Curso;

public record ProfessorRequest(
        String nome,
        String cpf,
        String turmas,
        String disciplinas
)
{}
