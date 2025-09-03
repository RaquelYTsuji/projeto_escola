package com.senai.projeto_escola.application.service;

import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.domain.entity.Curso;
import com.senai.projeto_escola.domain.repository.CursoRepository;
import com.senai.projeto_escola.application.dto.CursoMapper;
import com.senai.projeto_escola.application.dto.CursoRequest;
import com.senai.projeto_escola.application.dto.CursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoMapper cursoMapper;

    public CursoResponse create(CursoRequest cursoRequest){
        Curso curso = new Curso(cursoRequest.titulo(), cursoRequest.carga_horaria());
        cursoRepository.save(curso);
        return cursoMapper.to(curso);
    }

    public List<CursoResponse> getAll(){
        List<Curso> cursos = cursoRepository.findAll();
        return cursoMapper.to(cursos);
    }

    public CursoResponse getCurso(String id){
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return cursoMapper.to(curso);
    }

    public CursoResponse update(String id, CursoRequest cursoRequest){
        if(!cursoRepository.existsById(id)){
            new RuntimeException("Curso não encontrado");
        }

        Curso curso = new Curso(cursoRequest.titulo(), cursoRequest.carga_horaria());
        curso.setId(id);
        cursoRepository.save(curso);
        return cursoMapper.to(curso);
    }

    public void delete(String id){
        cursoRepository.deleteById(id);
    }

    public boolean existsCurso(String id){
        return cursoRepository.existsById(id);
    }

    public Curso returnCurso(String id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    public CursoResponse addAluno(Curso curso, String alunoId){
        if(curso.getAlunoId() == null){
            curso.getAlunoId().set(0, alunoId);
        } else {
            curso.getAlunoId().add(alunoId);
        }
        cursoRepository.save(curso);
        return cursoMapper.to(curso);
    }
}
