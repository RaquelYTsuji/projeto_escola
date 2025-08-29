package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.service.CursoService;
import com.senai.projeto_escola.domain.entity.Curso;
import com.senai.projeto_escola.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public Curso createCurso(@RequestBody Curso curso){
        return cursoRepository.save(curso);
    }

    @GetMapping
    public List<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso getAllCursos(@PathVariable String id){
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }

    @PutMapping("/{id}")
    public Curso updateCurso(@PathVariable String id, @RequestBody Curso cursoRequest){
        return cursoService.update(id, cursoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable String id){
        cursoRepository.deleteById(id);
    }
}
