package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.Curso;

public record AlunoResponse (
        String id,
        String nome,
        String cpf,
        Curso curso,
        String turma
)
{
    //    public static AlunoRequest fromEntity(Aluno aluno){
//        if(aluno == null) return null;
//        return new AlunoRequest(
//                aluno.getNome(),
//                aluno.getCpf(),
//                aluno.getCurso() != null ? aluno.getCurso().getId() : null,
//                aluno.getTurma()
//        );
//    }

//    public Aluno toEntity(AlunoRequest alunoRequest){
//        Aluno aluno = new Aluno();
//        aluno.setNome(this.nome);
//        aluno.setCpf(this.cpf);
//        aluno.setTipo(UsuarioTipo.aluno);
//        aluno.setTurma(this.turma);
//        aluno.setCurso(curso);
//        return aluno;
//    }
}
