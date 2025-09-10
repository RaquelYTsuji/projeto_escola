package com.senai.projeto_escola.application.dto;

import java.util.List;

public record CursoResponse(
        String id,
        String titulo,
        Integer cargaHoraria,
        List<AlunoResponse> alunos
)
{}
