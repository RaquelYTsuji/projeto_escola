package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.application.dto.AlunoMapper;
import com.senai.projeto_escola.application.dto.AlunoResponse;
import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.domain.entity.Curso;
import com.senai.projeto_escola.domain.repository.AlunoRepository;
import com.senai.projeto_escola.application.dto.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoMapper alunoMapper;

    @Autowired
    private CursoService cursoService;

    public AlunoResponse save(AlunoRequest alunoRequest){
        if(!cursoService.existsCurso(alunoRequest.curso())){
            new RuntimeException("Curso não encontrado");
        }
        Curso curso = cursoService.returnCurso(alunoRequest.curso());
        Aluno aluno = new Aluno(
                alunoRequest.nome(),
                alunoRequest.cpf(),
                curso,
                alunoRequest.turma()
        );
        Aluno addAluno = alunoRepository.save(aluno);
        cursoService.addAluno(curso, addAluno.getId());
        return alunoMapper.to(aluno);
    }

    public List<AlunoResponse> getAll(){
        List<Aluno> aluno = alunoRepository.findAll();
        return alunoMapper.to(aluno);
    }

    public AlunoResponse getAluno(String id){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return alunoMapper.to(aluno);
    }

    public AlunoResponse update(String id, AlunoRequest alunoRequest){
        if(!alunoRepository.existsById(id) || !cursoService.existsCurso(id)){
            new RuntimeException("Aluno ou Curso não encontrado");
        }

        Curso curso = cursoService.returnCurso(alunoRequest.curso());

        Aluno aluno = new Aluno(alunoRequest.nome(), alunoRequest.cpf(), curso, alunoRequest.turma());
        aluno.setId(id);
        alunoRepository.save(aluno);
        return alunoMapper.to(aluno);
    }

    public void delete(String id){
        alunoRepository.deleteById(id);
    }

}
