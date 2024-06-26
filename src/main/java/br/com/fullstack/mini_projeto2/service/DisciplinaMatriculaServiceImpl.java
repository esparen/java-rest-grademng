package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.repository.AlunoRepository;
import br.com.fullstack.mini_projeto2.repository.DisciplinaMatriculaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DisciplinaMatriculaServiceImpl implements DisciplinaMatriculaService{

    private final DisciplinaMatriculaRepository disciplinaMatriculaRepository;
    private final DisciplinaService disciplinaService;
    private final AlunoRepository alunoRepository;

    public DisciplinaMatriculaEntity createDisciplinaMatricula(Long idAluno, Long idDisciplina) throws Exception {
        AlunoEntity targetAluno = alunoRepository.findById(idAluno).orElse(null);
        if (targetAluno == null) throw new Exception("Aluno id [" + idAluno + "] não encontrado");

        DisciplinaEntity targetDisciplina = disciplinaService.getDisciplinaById(idDisciplina);
        if (targetDisciplina == null) throw new Exception("Disciplina id [" + idDisciplina + "] não encontrada");

        DisciplinaMatriculaEntity newMatricula = new DisciplinaMatriculaEntity();
        newMatricula.setDisciplina(targetDisciplina);
        newMatricula.setAluno(targetAluno);
        disciplinaMatriculaRepository.save(newMatricula);
        return newMatricula;
    }

    public void deleteMatricula(Long matriculaId) throws Exception {
        disciplinaMatriculaRepository.deleteById(matriculaId);
    }
    public DisciplinaMatriculaEntity getMatriculaById(Long id) throws Exception {
        Optional<DisciplinaMatriculaEntity> targetMatricula = disciplinaMatriculaRepository.findById(id);
        return targetMatricula.orElse(null);
    }
    public List<DisciplinaMatriculaEntity> getMatriculaByAlunoId(Long alunoId) throws Exception {
        List<DisciplinaMatriculaEntity> matriculasAluno = disciplinaMatriculaRepository.findByAlunoId(alunoId);
        return matriculasAluno;
    }
    public List<DisciplinaMatriculaEntity> getMatriculaByDisciplinaId(Long disciplinaId) throws Exception {
        List<DisciplinaMatriculaEntity> matriculasDisciplina = disciplinaMatriculaRepository.findByDisciplinaId(disciplinaId);
        return matriculasDisciplina;
    }
}
