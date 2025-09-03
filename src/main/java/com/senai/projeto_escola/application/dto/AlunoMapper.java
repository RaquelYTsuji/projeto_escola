package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.Aluno;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlunoMapper {
    AlunoResponse to(Aluno aluno);
    List<AlunoResponse> to(List<Aluno> alunos);
}
