package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.NotasEntity;

import java.util.List;

public interface NotasService {

    List<NotasEntity> getNotasByDisciplinaMatriculaId(Long matriculaId) throws Exception;

}
