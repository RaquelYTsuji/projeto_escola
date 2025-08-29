package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.service.AlunoService;
import com.senai.projeto_escola.domain.entity.Aluno;
import com.senai.projeto_escola.domain.repository.AlunoRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public Aluno createAluno(@RequestBody AlunoRequest alunoRequest){
        return alunoService.save(alunoRequest);
    }

    @GetMapping
    public List<Aluno> getAllAlunos(){
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getAllAlunos(@PathVariable String id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

    @PutMapping("/{id}")
    public Aluno updateAluno(@PathVariable String id, @RequestBody AlunoRequest alunoRequest){
        return alunoService.update(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable String id){
        alunoRepository.deleteById(id);
    }
}
