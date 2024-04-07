package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
public interface DisciplinaMatriculaService {

    DisciplinaMatriculaEntity createDisciplinaMatricula(Long idAluno, Long idDisciplina) throws Exception;

    //void deleteMatricula(Long id) throws Exception;

    DisciplinaMatriculaEntity getMatriculaById(Long id) throws Exception;

    //DisciplinaMatriculaEntity getMatriculaByAlunoId(Long id) throws Exception;

    //DisciplinaMatriculaEntity getMatriculaByDisciplinaId(Long id) throws Exception;
}
