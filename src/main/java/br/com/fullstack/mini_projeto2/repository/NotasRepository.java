package br.com.fullstack.mini_projeto2.repository;

import br.com.fullstack.mini_projeto2.entity.NotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotasRepository extends JpaRepository<NotasEntity, Long> {

}
