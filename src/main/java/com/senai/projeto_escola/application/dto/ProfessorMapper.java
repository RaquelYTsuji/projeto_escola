package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.Professor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {
    ProfessorResponse to(Professor professor);
    List<ProfessorResponse> to(List<Professor> professores);
}
