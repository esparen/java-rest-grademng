package br.com.fullstack.mini_projeto2.controller;

import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import br.com.fullstack.mini_projeto2.service.DisciplinaServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaServiceImpl disciplinaServiceImpl;

    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> getAllDisciplinas(){
        log.info("GET /disciplinas -> Início");
        List<DisciplinaEntity> disciplinas = disciplinaServiceImpl.getAllDisciplinas();
        log.info("GET /disciplinas -> Encontrados {} registros", disciplinas.size());
        log.info("GET /disciplinas -> 200 OK");
        return ResponseEntity.status(HttpStatus.OK).body(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> getDisciplinasById(@PathVariable Long id) throws Exception {
        log.info("GET /disciplinas/{} -> Início", id);
        DisciplinaEntity disciplinaEntity = disciplinaServiceImpl.getDisciplinaById(id);
        log.info("GET /disciplinas/{} -> Encontrada", id);
        log.info("GET /disciplinas/{} -> 200 OK", id);
        return disciplinaEntity != null ? ResponseEntity.ok(disciplinaEntity) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public DisciplinaEntity createDisciplina(@RequestBody DisciplinaEntity disciplinaEntity){
        log.info("POST /disciplinas -> Início");
        DisciplinaEntity disciplina = disciplinaServiceImpl.createDisciplina(disciplinaEntity);
        log.info("POST /disciplinas -> Cadastrada");
        log.info("POST /disciplinas -> 201 CREATED");
        return disciplina;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> updateDisciplina(@PathVariable Long id, @RequestBody DisciplinaEntity disciplinaChanges) throws Exception {
            log.info("PUT /disciplinas/{}", id);
            DisciplinaEntity disciplinaUpdated = disciplinaServiceImpl.updateDisciplina(id, disciplinaChanges);
            log.info("GET /disciplinas/{} -> Atualizada", id);
            log.info("GET /disciplinas/{} -> 200 OK", id);
            return disciplinaUpdated != null ? ResponseEntity.ok(disciplinaUpdated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable Long id) throws Exception {
        log.info("DELETE /disciplinas/{}", id);
        disciplinaServiceImpl.deleteDisciplina(id);
        log.info("DELETE /disciplinas/{} -> Excluída", id);
        log.info("DELETE /disciplinas/{} -> 204 NO CONTENT", id);
        return ResponseEntity.ok().build();
    }

}
