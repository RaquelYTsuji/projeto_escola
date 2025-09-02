package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.service.AlunoService;
import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.interface_ui.controller.dto.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno createAluno(@RequestBody AlunoRequest alunoRequest){
        return alunoService.save(alunoRequest);
    }

    @GetMapping
    public List<Aluno> getAllAlunos(){
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public Aluno getAluno(@PathVariable String id){
        return alunoService.getAluno(id);
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable String id, @RequestBody AlunoRequest alunoRequest){
        return alunoService.update(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable String id){
        alunoService.delete(id);
    }
}
