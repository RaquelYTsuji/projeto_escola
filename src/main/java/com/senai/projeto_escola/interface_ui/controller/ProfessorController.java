package com.senai.projeto_escola.interface_ui.controller;

import com.senai.projeto_escola.application.service.ProfessorService;
import com.senai.projeto_escola.domain.entity.Professor;
import com.senai.projeto_escola.domain.repository.ProfessorRepository;
import com.senai.projeto_escola.interface_ui.controller.dto.ProfessorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public Professor createProfessor(@RequestBody ProfessorRequest professorRequest){
        return professorService.save(professorRequest);
    }

    @GetMapping
    public List<Professor> getAllProfessoress(){
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Professor getAllProfessoress(@PathVariable String id){
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    @PutMapping("/{id}")
    public Professor updateProfessor(@PathVariable String id, @RequestBody ProfessorRequest professorRequest){
        return professorService.update(id, professorRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessor(@PathVariable String id){
        professorRepository.deleteById(id);
    }
}
