package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.domain.entity.Curso;
import com.senai.projeto_escola.domain.repository.AlunoRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoService cursoService;

    public Aluno save(AlunoRequest alunoRequest){
        if(!cursoService.existsCurso(alunoRequest.curso())){
            new RuntimeException("Curso não encontrado");
        }
        Curso curso = cursoService.getCurso(alunoRequest.curso());
        Aluno aluno = new Aluno(
                alunoRequest.nome(),
                alunoRequest.cpf(),
                curso,
                alunoRequest.turma()
        );
        curso.getAlunoId().add(aluno.getId());
        cursoService.saveCurso(curso);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Aluno getAluno(String id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    public Aluno update(String id, AlunoRequest alunoRequest){
        if(!alunoRepository.existsById(id) || !cursoService.existsCurso(id)){
            new RuntimeException("Aluno ou Curso não encontrado");
        }

        Curso curso = cursoService.getCurso(alunoRequest.curso());

        Aluno aluno = new Aluno(alunoRequest.nome(), alunoRequest.cpf(), curso, alunoRequest.turma());
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void delete(String id){
        alunoRepository.deleteById(id);
    }

}
