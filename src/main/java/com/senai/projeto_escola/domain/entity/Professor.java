package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Professor extends Usuario{
    @ElementCollection
    @CollectionTable(name = "professor_turmas",
            joinColumns = @JoinColumn(name = "professor_id"))
    @Column(name = "turmas")
    private List<String> turmas;

    @ElementCollection
    @CollectionTable(name = "professor_disciplinas",
            joinColumns = @JoinColumn(name = "professor_id"))
    @Column(name = "disciplinas")
    private List<String> disciplinas;

    public Professor(String nome, String cpf, List<String> turmas, List<String> disciplinas) {
        super(nome, cpf, UsuarioTipo.professor);
        this.turmas = turmas;
        this.disciplinas = disciplinas;
    }
}
