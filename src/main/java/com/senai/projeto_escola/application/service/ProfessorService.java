package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.application.dto.ProfessorMapper;
import com.senai.projeto_escola.application.dto.ProfessorResponse;
import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.repository.ProfessorRepository;
import com.senai.projeto_escola.application.dto.ProfessorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorMapper professorMapper;

    public ProfessorResponse save(ProfessorRequest professorRequest){
        Professor professor = new Professor(
                professorRequest.nome(),
                professorRequest.cpf(),
                professorRequest.turmas(),
                professorRequest.disciplinas()
        );
        professorRepository.save(professor);
        return professorMapper.to(professor);
    }

    public List<ProfessorResponse> getAll(){
        List<Professor> professores = professorRepository.findAll();
        return professorMapper.to(professores);
    }

    public ProfessorResponse getProfessor(String id){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return professorMapper.to(professor);
    }

    public ProfessorResponse update(String id, ProfessorRequest professorRequest){
        if(!professorRepository.existsById(id)){
            new RuntimeException("Professor não encontrado");
        }

        Professor professor = new Professor(professorRequest.nome(), professorRequest.cpf(), professorRequest.turmas(), professorRequest.disciplinas());
        professor.setId(id);
        professorRepository.save(professor);
        return professorMapper.to(professor);
    }

    public void delete(String id){
        professorRepository.deleteById(id);
    }
}
