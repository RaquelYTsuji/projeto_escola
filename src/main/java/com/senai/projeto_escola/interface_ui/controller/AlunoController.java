package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.dto.AlunoResponse;
import com.senai.projeto_escola.application.service.AlunoService;
import com.senai.projeto_escola.application.dto.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public AlunoResponse createAluno(@RequestBody AlunoRequest alunoRequest){
        return alunoService.save(alunoRequest);
    }

    @GetMapping
    public List<AlunoResponse> getAllAlunos(){
        return alunoService.getAll();
    }

    @GetMapping("/{id}")
    public AlunoResponse getAluno(@PathVariable String id){
        return alunoService.getAluno(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse updateAluno(@PathVariable String id, @RequestBody AlunoRequest alunoRequest){
        return alunoService.update(id, alunoRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable String id){
        alunoService.delete(id);
    }
}
