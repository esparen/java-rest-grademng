package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;

import java.util.List;
public interface DisciplinaService {

    List<DisciplinaEntity> getAllDisciplinas();

    DisciplinaEntity getDisciplinaById(Long id) throws Exception;

    DisciplinaEntity createDisciplina(DisciplinaEntity disciplina) throws Exception;

    DisciplinaEntity updateDisciplina(Long id, DisciplinaEntity disciplina) throws Exception;

    void deleteDisciplina(Long id) throws Exception;

}