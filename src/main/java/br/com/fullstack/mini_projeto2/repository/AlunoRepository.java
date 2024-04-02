package br.com.fullstack.mini_projeto2.repository;

import br.com.fullstack.mini_projeto2.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

}
