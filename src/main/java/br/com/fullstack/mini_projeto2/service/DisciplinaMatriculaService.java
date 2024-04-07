package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;

import java.util.List;

public interface DisciplinaMatriculaService {

    DisciplinaMatriculaEntity createDisciplinaMatricula(Long idAluno, Long idDisciplina) throws Exception;

    //void deleteMatricula(Long id) throws Exception;

    DisciplinaMatriculaEntity getMatriculaById(Long id) throws Exception;

    List<DisciplinaMatriculaEntity> getMatriculaByAlunoId(Long alunoId) throws Exception;

    List<DisciplinaMatriculaEntity> getMatriculaByDisciplinaId(Long disciplinaId) throws Exception;
}
