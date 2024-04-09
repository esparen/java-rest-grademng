package br.com.fullstack.mini_projeto2.controller;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.service.AlunoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public void setAlunoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @Data
    public static class AlunoMediasGerais {
        private final Double mediaGeral;
        private final ArrayList<String> mediaFinalDisciplina;
    }

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

    @GetMapping("/{alunoId}/mediageral")
    public ResponseEntity getAlunoMediaGeral(@PathVariable Long alunoId) throws Exception {
        try {
            AlunoMediasGerais alunoMediasGerais = alunoService.getAlunoMediaGeral(alunoId);
            return ResponseEntity.ok(alunoMediasGerais);
        } catch(Exception e)  {
            return ResponseEntity.internalServerError().body("Erro ao calcular a média geral do aluno:" + e.getMessage());
        }
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
