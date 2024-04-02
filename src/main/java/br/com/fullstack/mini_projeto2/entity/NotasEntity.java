package br.com.fullstack.mini_projeto2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notas")
public class NotasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "disciplina_matricula")
    @ManyToOne
    private DisciplinaEntity disciplinaEntity;

    @Column(name = "professor")
    @ManyToOne
    private ProfessorEntity professorEntity;

    @Column(name = "notas")
    private Double nota;

    @Column(name = "coeficiente")
    private Double coeficiente_numerico;
}
