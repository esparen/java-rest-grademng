package br.com.fullstack.mini_projeto2.controller;


import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.service.DisciplinaMatriculaServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/matricula")
public class DisciplinaMatriculaController {
    private final DisciplinaMatriculaServiceImpl disciplinaMatriculaServiceImpl;
    @Data
    private static class MatriculaRequest {
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
}
