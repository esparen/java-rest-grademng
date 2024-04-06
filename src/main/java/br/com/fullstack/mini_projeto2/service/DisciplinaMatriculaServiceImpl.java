package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.service.AlunoService;
import br.com.fullstack.mini_projeto2.repository.DisciplinaMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DisciplinaMatriculaServiceImpl implements DisciplinaMatriculaService{

    private final DisciplinaMatriculaRepository disciplinaMatriculaRepository;
    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;
    public DisciplinaMatriculaEntity createDisciplinaMatricula(Long idAluno, Long idDisciplina) throws Exception {
        AlunoEntity targetAluno = alunoService.getAlunoById(idAluno);
        if (targetAluno == null) throw new Exception("Aluno id [" + idAluno + "] não encontrado");

        DisciplinaEntity targetDisciplina = disciplinaService.getDisciplinaById(idDisciplina);
        if (targetDisciplina == null) throw new Exception("Disciplina id [" + idDisciplina + "] não encontrada");

        DisciplinaMatriculaEntity newMatricula = new DisciplinaMatriculaEntity();
        newMatricula.setDisciplinaEntity(targetDisciplina);
        newMatricula.setAlunoEntity(targetAluno);
        disciplinaMatriculaRepository.save(newMatricula);
        return newMatricula;
    }

    //    DELETE:
    //    Deve receber apelas o id no PathVariable;
    //    Validar se existe notas já lançadas:
    //    Caso exista, informar a falha ao cliente;
    //    Caso NÃO exista, deve excluir a matrícula.

    //    GET Por ID**:**
    //    Deve receber apelas o id no PathVariable;
    //    Retornar uma matrícula que tenha o ID informado.

    //    GET Por aluno**:**
    //    Deve receber apelas o id de aluno no PathVariable;
    //    Retornar todas as matrículas pertencentes à um aluno.

    //    GET Por disciplina**:**
    //    Deve receber apelas o id da matrícula no PathVariable
    //    Retornar todas as matrículas pertencentes à uma disciplina
}
