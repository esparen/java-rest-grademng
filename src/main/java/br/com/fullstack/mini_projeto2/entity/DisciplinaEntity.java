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

    private String nome;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professorEntity;
}
