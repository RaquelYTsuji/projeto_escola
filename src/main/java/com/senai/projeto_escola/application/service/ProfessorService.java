package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.repository.ProfessorRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.ProfessorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public List<Professor> getAll(){
        return professorRepository.findAll();
    }

    public Professor getProfessor(String id){
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    public Professor update(String id, ProfessorRequest professorRequest){
        if(!professorRepository.existsById(id)){
            new RuntimeException("Professor não encontrado");
        }

        Professor professor = new Professor(professorRequest.nome(), professorRequest.cpf(), professorRequest.turmas(), professorRequest.disciplinas());
        professor.setId(id);
        return professorRepository.save(professor);
    }

    public void delete(String id){
        professorRepository.deleteById(id);
    }
}
