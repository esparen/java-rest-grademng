package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.repository.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoEntity> getAllAlunos(){
        logger.info("Listando todos os alunos");
        return alunoRepository.findAll();
    }

    public ResponseEntity<AlunoEntity> getAlunoById(Long id) throws Exception {
        AlunoEntity alunoEntity = alunoRepository.findById(id).orElseThrow(
                () -> new Exception(
                        "Aluno com id " + id + " não encontrado"
                ));
        return ResponseEntity.ok(alunoEntity);
    }

    public AlunoEntity createAluno(AlunoEntity alunoEntity){
        logger.info("Criando aluno");
        return alunoRepository.save(alunoEntity);
    }

    public AlunoEntity updateAluno(Long id, AlunoEntity alunoEntity) throws Exception {
        alunoRepository.findById(id).orElseThrow(
                () -> new Exception(
                        "Aluno com id " + id + " não encontrado"
                )
        );
        return alunoRepository.save(alunoEntity);
    }

    public void deleteAlunoById(Long id) throws Exception {
        alunoRepository.findById(id).orElseThrow(
                () -> new Exception(
                        "Aluno com id" + id + "não encontrado"
                )
        );
        alunoRepository.deleteById(id);
    }
}
