package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Aluno extends Usuario{
    private Curso curso;
    @NotBlank(message = "titulo não pode ser vazio")
    private String turma;


    public Aluno(String nome, String cpf, Curso curso, String turma) {
        super(nome, cpf, UsuarioTipo.aluno);
        this.curso = curso;
        this.turma = turma;
    }
}
