package br.com.fullstack.mini_projeto2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "disciplinas")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_disciplina", nullable = false)
    private String nome;

    @Column(name = "professor_id")
    @ManyToOne
    private ProfessorEntity professorEntity;
}
