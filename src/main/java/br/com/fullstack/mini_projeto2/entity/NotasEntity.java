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

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaEntity disciplinaEntity;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professorEntity;

    private Double nota;

    private Double coeficiente_numerico;
}
