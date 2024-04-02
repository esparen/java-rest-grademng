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

    @Column(name = "aluno_id", nullable = false)
    @ManyToOne
    private AlunoEntity alunoEntity;

    @Column(name = "disciplina_id")
    @ManyToOne
    private DisciplinaEntity disciplinaEntity;

    @Column(name = "data_matricula", nullable = false)
    private LocalDate dataMatricula = LocalDate.now();

    @Column(name = "media_final")
    private Double mediaFinal = 0.00;
}
