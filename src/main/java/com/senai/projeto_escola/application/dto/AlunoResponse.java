package com.senai.projeto_escola.application.dto;

import com.senai.projeto_escola.domain.entity.Curso;

public record AlunoResponse (
        String id,
        String nome,
        String cpf,
        CursoAlunoResponse curso,
        String turma
)
{
    //    public static AlunoResponse fromEntity(Aluno aluno){
//        if(aluno == null) return null;
//        return new AlunoResponse(
//                aluno.getNome(),
//                aluno.getCpf(),
//                aluno.getCurso() != null ? aluno.getCurso().getId() : null,
//                aluno.getTurma()
//        );
//    }

//    public Aluno toEntity(AlunoResponse alunoResponse){
//        Aluno aluno = new Aluno();
//        aluno.setNome(this.nome);
//        aluno.setCpf(this.cpf);
//        aluno.setTipo(UsuarioTipo.aluno);
//        aluno.setTurma(this.turma);
//        aluno.setCurso(curso);
//        return aluno;
//    }
}
