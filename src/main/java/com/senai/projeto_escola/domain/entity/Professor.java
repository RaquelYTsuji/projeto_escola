package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Professor extends Usuario{
    @NotBlank(message = "turmas não pode ser vazio")
    private String turmas;
    @NotBlank(message = "disciplinas não pode ser vazio")
    private String disciplinas;

    public Professor(String nome, String cpf, String turmas, String disciplinas) {
        super(nome, cpf, UsuarioTipo.aluno);
        this.turmas = turmas;
        this.disciplinas = disciplinas;
    }
}
