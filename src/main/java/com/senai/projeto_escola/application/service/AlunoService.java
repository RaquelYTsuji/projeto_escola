package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.domain.entity.UsuarioTipo;
import com.senai.projeto_escola.domain.repository.AlunoRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno save(AlunoRequest alunoRequest){
        Aluno aluno = new Aluno(
                alunoRequest.nome(),
                alunoRequest.cpf(),
                alunoRequest.curso(),
                alunoRequest.turma()
        );
        return alunoRepository.save(aluno);
    }

    public Aluno update(String id, AlunoRequest alunoRequest){
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setNome(alunoRequest.nome());
        aluno.setCpf(alunoRequest.cpf());
        aluno.setTipo(UsuarioTipo.aluno);
        aluno.setCurso(alunoRequest.curso());
        aluno.setTurma(alunoRequest.turma());

        return alunoRepository.save(aluno);
    }
}
