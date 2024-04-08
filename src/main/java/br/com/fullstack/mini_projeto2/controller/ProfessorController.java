package br.com.fullstack.mini_projeto2.controller;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.entity.ProfessorEntity;
import br.com.fullstack.mini_projeto2.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorEntity> getAllProfessores(){
        return professorService.getAllProfessores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> getProfessorById(@PathVariable Long id) throws Exception {
        ProfessorEntity professorEntity = professorService.getProfessorById(id);
        return professorEntity != null
                ? ResponseEntity.ok(professorEntity)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ProfessorEntity createAluno(@RequestBody ProfessorEntity professorEntity){
        return professorService.createProfessor(professorEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorEntity> updateAluno(@PathVariable Long id,
                                                   @RequestBody ProfessorEntity professorChanges) throws Exception {
        ProfessorEntity professorUpdated = professorService.updateProfessor(id, professorChanges);
        return professorUpdated != null
                ? ResponseEntity.ok(professorUpdated)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) throws Exception {
        professorService.deleteProfessor(id);
        return ResponseEntity.ok().build();
    }
}
