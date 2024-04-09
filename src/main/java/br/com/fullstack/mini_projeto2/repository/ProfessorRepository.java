package br.com.fullstack.mini_projeto2.repository;

import br.com.fullstack.mini_projeto2.entity.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {

}
