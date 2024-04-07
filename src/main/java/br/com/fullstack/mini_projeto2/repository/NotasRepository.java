package br.com.fullstack.mini_projeto2.repository;

import br.com.fullstack.mini_projeto2.entity.DisciplinaMatriculaEntity;
import br.com.fullstack.mini_projeto2.entity.NotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotasRepository extends JpaRepository<NotasEntity, Long> {
    List<NotasEntity> findByDisciplinaMatriculaId(Long matriculaId);

}
