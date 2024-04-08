package br.com.fullstack.mini_projeto2.service;

import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.entity.NotasEntity;
import org.springframework.lang.NonNull;

import java.util.List;

public interface NotasService {

    List<NotasEntity> getNotasByDisciplinaMatriculaId(Long matriculaId) throws Exception;

    NotasEntity addNota(@NonNull DisciplinaMatriculaEntity matricula, @NonNull Double nota, @NonNull Double coeficiente) throws Exception;

    private DisciplinaMatriculaEntity updateMediaGeral(@NonNull DisciplinaMatriculaEntity matricula) throws Exception {
        return null;
    }

}
