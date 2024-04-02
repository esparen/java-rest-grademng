package br.com.fullstack.mini_projeto2.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "disciplina_maticulas")
public class DisciplinaMatriculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity alunoEntity;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaEntity disciplinaEntity;

    private LocalDate dataMatricula = LocalDate.now();

    private Double mediaFinal = 0.00;
}
