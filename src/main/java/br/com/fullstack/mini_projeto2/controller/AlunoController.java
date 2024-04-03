package br.com.fullstack.mini_projeto2.controller;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AlunoEntity getALunosById(@PathVariable Long id) throws Exception {
        return alunoService.getAlunoById(id).getBody();
    }

    @PostMapping
    public AlunoEntity createAluno(@RequestBody AlunoEntity alunoEntity){
        return alunoService.createAluno(alunoEntity);
    }

    @PutMapping("/{id}")
    public AlunoEntity updateAluno(@PathVariable Long id, @RequestBody AlunoEntity alunoEntity) throws Exception {
        return alunoService.updateAluno(id, alunoEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteAluno(@PathVariable Long id) throws Exception {
        alunoService.deleteAlunoById(id);
    }
}
