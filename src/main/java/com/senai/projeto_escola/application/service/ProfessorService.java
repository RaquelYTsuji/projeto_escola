package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.entity.UsuarioTipo;
import com.senai.projeto_escola.domain.repository.AlunoRepository;
import com.senai.projeto_escola.domain.repository.ProfessorRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.AlunoRequest;
import com.senai.projeto_escola.interface_ui.controller.dto.ProfessorRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor save(ProfessorRequest professorRequest){
        Professor professor = new Professor(
                professorRequest.nome(),
                professorRequest.cpf(),
                professorRequest.turmas(),
                professorRequest.disciplinas()
        );
        return professorRepository.save(professor);
    }

    public Professor update(String id, ProfessorRequest professorRequest){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        professor.setNome(professorRequest.nome());
        professor.setCpf(professorRequest.cpf());
        professor.setTipo(UsuarioTipo.aluno);
        professor.setTurmas(professorRequest.turmas());
        professor.setDisciplinas(professorRequest.disciplinas());

        return professorRepository.save(professor);
    }
}
