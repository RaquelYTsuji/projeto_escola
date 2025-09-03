package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.Curso;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    CursoResponse to(Curso curso);
    List<CursoResponse> to(List<Curso> cursos);
}
