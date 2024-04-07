package br.com.fullstack.mini_projeto2.controller;


import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.entity.NotasEntity;
import br.com.fullstack.mini_projeto2.service.DisciplinaMatriculaServiceImpl;
import br.com.fullstack.mini_projeto2.service.NotasServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/matricula")
public class DisciplinaMatriculaController {
    private final DisciplinaMatriculaServiceImpl disciplinaMatriculaServiceImpl;
    private final NotasServiceImpl notasServiceImpl;
    @Data
    public static class MatriculaRequest {
        private final Long idAluno;
        private final Long idDisciplina;
    }
    @PostMapping
    public ResponseEntity createMatricula(@RequestBody MatriculaRequest matriculaRequest) {
        try {
            DisciplinaMatriculaEntity matricula = disciplinaMatriculaServiceImpl.createDisciplinaMatricula(matriculaRequest.getIdAluno(), matriculaRequest.getIdDisciplina());
            log.info("POST /matricula -> 201 CREATED");
            return ResponseEntity.status(HttpStatus.CREATED).body(matricula);
        } catch(Exception e)  {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/bymatricula/{matriculaId}")
    public ResponseEntity getMatriculaByMatriculaId(@PathVariable Long matriculaId) {
        try {
            log.info("GET /matricula/bymatricula");
            DisciplinaMatriculaEntity matricula = disciplinaMatriculaServiceImpl.getMatriculaById(matriculaId);
            if (matricula == null) {
                log.info("GET /matricula/bymatricula -> 400 BAD_REQUEST");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nenhuma matricula com id ["+ matriculaId +"] encontrada");
            } else {
                log.info("GET /matricula/bymatricula -> 200 OK");
                return ResponseEntity.status(HttpStatus.OK).body(matricula);
            }
        } catch(Exception e)  {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/byaluno/{alunoId}")
    public ResponseEntity getMatriculaByAlunoId(@PathVariable Long alunoId) {
        try {
            log.info("GET /matricula/byaluno");
            List<DisciplinaMatriculaEntity> matriculasAluno = disciplinaMatriculaServiceImpl.getMatriculaByAlunoId(alunoId);
            if (matriculasAluno.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(matriculasAluno);

        } catch(Exception e)  {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/bydisciplina/{disciplinaId}")
    public ResponseEntity getMatriculaByDisciplinaId(@PathVariable Long disciplinaId) {
        try {
            log.info("GET /matricula/bydisciplina");
            List<DisciplinaMatriculaEntity> matriculasDisciplina = disciplinaMatriculaServiceImpl.getMatriculaByDisciplinaId(disciplinaId);
            if (matriculasDisciplina.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(matriculasDisciplina);

        } catch(Exception e)  {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{matriculaId}")
    public ResponseEntity deleteMatriculaByMatriculaId(@PathVariable Long matriculaId) {
        try {
            log.info("DELETE /matricula");
            DisciplinaMatriculaEntity matricula = disciplinaMatriculaServiceImpl.getMatriculaById(matriculaId);
            if (matricula == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Matricula ["+ matriculaId+"] não encontrada");

            List<NotasEntity> notasMatricula = notasServiceImpl.getNotasByDisciplinaMatriculaId(matriculaId);
            if (notasMatricula == null || notasMatricula.isEmpty()) {
                disciplinaMatriculaServiceImpl.deleteMatricula(matriculaId);
                return ResponseEntity.noContent().build();
            } else
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Impossível remover , a matricula [" + matriculaId + "], possui notas lançadas");
        } catch(Exception e)  {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
