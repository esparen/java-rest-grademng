package br.com.fullstack.mini_projeto2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "alunos")
public class AlunoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

}
