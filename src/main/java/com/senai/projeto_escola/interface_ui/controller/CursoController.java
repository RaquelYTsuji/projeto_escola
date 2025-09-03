package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.service.CursoService;
import com.senai.projeto_escola.application.dto.CursoRequest;
import com.senai.projeto_escola.application.dto.CursoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public CursoResponse createCurso(@RequestBody CursoRequest curso){
        return cursoService.create(curso);
    }

    @GetMapping
    public List<CursoResponse> getAllCursos(){
        return cursoService.getAll();
    }

    @GetMapping("/{id}")
    public CursoResponse getAllCursos(@PathVariable String id){
        return cursoService.getCurso(id);
    }

    @PutMapping("/{id}")
    public CursoResponse updateCurso(@PathVariable String id, @RequestBody CursoRequest cursoRequest){
        return cursoService.update(id, cursoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable String id){
        cursoService.delete(id);
    }
}
