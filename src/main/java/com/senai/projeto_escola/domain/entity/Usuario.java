package com.senai.projeto_escola.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "nome não pode ser vazio")
    private String nome;
    @NotBlank(message = "cpf não pode ser vazio")
    @Size(min = 11, max = 11, message = "Tamanho do cpf tem que ser 11")
    private String cpf;
    @Enumerated(EnumType.STRING)
    private UsuarioTipo tipo;

    public Usuario(String nome, String cpf, UsuarioTipo tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
    }
}
