package com.fiap.gerenciadorescolar.Model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rm;
    
    @NotNull(message = "{aluno.nulo}")
    @Size(min = 4, max = 100, message = "{aluno.nome.tamanho}")
    private String nome;
    
    @NotNull(message = "{aluno.nulo}")
    private String turma;

    public Aluno(Long rm, String nome, String turma){
        this.rm = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.turma = turma;
    }
}
