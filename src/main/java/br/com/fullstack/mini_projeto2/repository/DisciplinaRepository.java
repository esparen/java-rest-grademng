package br.com.fullstack.mini_projeto2.repository;

import br.com.fullstack.mini_projeto2.entity.DisciplinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<DisciplinaEntity, Long> {

}
