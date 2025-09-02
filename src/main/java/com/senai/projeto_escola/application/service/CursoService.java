package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Curso;
import com.senai.projeto_escola.domain.repository.CursoRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.CursoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    public Curso create(CursoRequest cursoRequest){
        Curso curso = new Curso(cursoRequest.titulo(), cursoRequest.carga_horaria());
        return cursoRepository.save(curso);
    }

    public List<Curso> getAll(){
        return cursoRepository.findAll();
    }

    public Curso getCurso(String id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public Curso update(String id, CursoRequest cursoRequest){
        if(!cursoRepository.existsById(id)){
            new RuntimeException("Curso não encontrado");
        }

        Curso curso = new Curso(cursoRequest.titulo(), cursoRequest.carga_horaria());
        curso.setId(id);
        return cursoRepository.save(curso);
    }

    public void delete(String id){
        cursoRepository.deleteById(id);
    }

    public boolean existsCurso(String id){
        return cursoRepository.existsById(id);
    }

    public Curso saveCurso(Curso curso){
        return cursoRepository.save(curso);
    }
}
