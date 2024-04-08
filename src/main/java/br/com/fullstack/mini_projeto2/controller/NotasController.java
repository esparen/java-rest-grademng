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

import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/notas")
public class NotasController {
    private final NotasServiceImpl notasService;
    private final DisciplinaMatriculaServiceImpl disciplinaMatriculaService;

    @Data
    public static class NewNotaRequest{
        private final Long matriculaId;
        private final Double nota;
        private final Double coeficiente;

        public void validateRequest() throws Exception{
            if (matriculaId == null) throw new IllegalArgumentException("matriculaId não pode ser null nem vazio");
            if (nota == null) throw new IllegalArgumentException("nota não pode ser null nem vazio");
            if (coeficiente == null) throw new IllegalArgumentException("corficiente não pode ser null nem vazio");
        }
    }
    @PostMapping
    public ResponseEntity submitNota(@RequestBody NewNotaRequest notaRequest) {
        try {
            log.info("POST /notas");
            notaRequest.validateRequest();
            DisciplinaMatriculaEntity targetMatricula = disciplinaMatriculaService.getMatriculaById(notaRequest.getMatriculaId());
            NotasEntity newNota = notasService.addNota(targetMatricula, notaRequest.getNota(), notaRequest.getCoeficiente());
            log.info("POST /notas -> 201 CREATED");
            return ResponseEntity.status(HttpStatus.CREATED).body(newNota);
        }
        catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{notaId}")
    public ResponseEntity deleteNota(@PathVariable Long notaId) throws Exception {
        log.info("DELETE /notas");
        try {
            NotasEntity targetNota = notasService.getNotaById(notaId);
            if (Objects.isNull(targetNota))
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Impossivel excluir, Nota com id [" + notaId + "] não encontrada");
            else {
                notasService.deleteNota(targetNota);
                return ResponseEntity.noContent().build();
            }
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
