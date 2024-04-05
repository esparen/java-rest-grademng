package br.com.fullstack.mini_projeto2.controller;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoEntity> getAllAlunos(){
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoEntity> getALunosById(@PathVariable Long id) throws Exception {
        AlunoEntity alunoEntity = alunoService.getAlunoById(id);
        return alunoEntity != null
                ? ResponseEntity.ok(alunoEntity)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public AlunoEntity createAluno(@RequestBody AlunoEntity alunoEntity){
        return alunoService.createAluno(alunoEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoEntity> updateAluno(@PathVariable Long id,
                                                   @RequestBody AlunoEntity alunoChanges) throws Exception {
        AlunoEntity alunoUpdated = alunoService.updateAluno(id, alunoChanges);
        return alunoUpdated != null
                ? ResponseEntity.ok(alunoUpdated)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) throws Exception {
        alunoService.deleteAluno(id);
        return ResponseEntity.ok().build();
    }
}
