package br.com.fullstack.mini_projeto2.repository;

import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DisciplinaMatriculaRepository extends JpaRepository<DisciplinaMatriculaEntity, Long> {
    List<DisciplinaMatriculaEntity> findByAlunoId(Long alunoId);

    List<DisciplinaMatriculaEntity> findByDisciplinaId(Long disciplinaId);
}
