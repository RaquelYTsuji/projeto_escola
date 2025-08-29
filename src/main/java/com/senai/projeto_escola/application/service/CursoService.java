package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Curso;
import com.senai.projeto_escola.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso update(String id, Curso cursoRequest){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setTitulo(cursoRequest.getTitulo());
        curso.setCarga_horaria(cursoRequest.getCarga_horaria());
        return cursoRepository.save(curso);
    }
}
