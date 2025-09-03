package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "titulo não pode ser vazio")
    private String titulo;
    @NotNull(message = "carga_horaria não pode ser nulo")
    private Integer carga_horaria;
    @MapsId("alunoId")
    private List<String> alunoId;

    public Curso(String titulo, Integer carga_horaria) {
        this.titulo = titulo;
        this.carga_horaria = carga_horaria;
        this.alunoId = new ArrayList<>();
    }
}
