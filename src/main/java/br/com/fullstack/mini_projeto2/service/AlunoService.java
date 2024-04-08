package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.controller.AlunoController;
import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.repository.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private static final Logger logger = LoggerFactory.getLogger(AlunoService.class);
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private DisciplinaMatriculaServiceImpl disciplinaMatriculaService;

    public List<AlunoEntity> getAllAlunos() {
        logger.info("Listando todos os alunos");
        return alunoRepository.findAll();
    }

    public AlunoEntity getAlunoById(Long id) throws Exception {
        Optional<AlunoEntity> alunoEntity = alunoRepository.findById(id);
        return alunoEntity.orElseThrow(
                () -> new Exception(
                        "Aluno com id: " + id + " não encotrado!"
                )
        );
    }

    public AlunoEntity createAluno(AlunoEntity alunoEntity) {
        logger.info("Criando aluno");
        return alunoRepository.save(alunoEntity);
    }

    public AlunoEntity updateAluno(Long id, AlunoEntity alunoUpdated) throws Exception {
        AlunoEntity alunoEntity = getAlunoById(id);

        if (alunoEntity != null) {
            alunoEntity.setNome(alunoUpdated.getNome());
            alunoEntity.setDataNascimento(alunoUpdated.getDataNascimento());
        }

        return alunoRepository.save(alunoEntity);
    }

    public void deleteAluno(Long id) throws Exception {
        alunoRepository.findById(id).orElseThrow(
                () -> new Exception(
                        "Aluno com id" + id + "não encontrado"
                )
        );
        alunoRepository.deleteById(id);
    }
    public AlunoController.AlunoMediasGerais getAlunoMediaGeral(Long alunoId) throws Exception {
        List<DisciplinaMatriculaEntity> disciplinasAluno = disciplinaMatriculaService.getMatriculaByAlunoId(alunoId);
        if (disciplinasAluno.isEmpty()) throw new Exception("o aluno ["+alunoId+"] não possui matricula em disciplinas");

        Double mediaGeralAluno = disciplinasAluno.stream()
                .mapToDouble(matricula -> matricula.getMediaFinal())
                .filter(mediaFinal -> mediaFinal != 0 && !Double.isNaN(mediaFinal))
                .average()
                .orElse(Double.NaN);
        if (Double.isNaN(mediaGeralAluno)) {
            throw new ArithmeticException("Não existem médias finais nas disciplinas do aluno id [" + alunoId + "] ");
        }

        ArrayList<String> mediasFinaisDisciplinas = new ArrayList<>();
        disciplinasAluno.forEach(matricula ->
                mediasFinaisDisciplinas.add(matricula.getDisciplina().getNome() + ":" + matricula.getMediaFinal())
        );
        return new AlunoController.AlunoMediasGerais(mediaGeralAluno, mediasFinaisDisciplinas);
    }


}