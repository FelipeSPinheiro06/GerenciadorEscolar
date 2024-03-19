package com.fiap.gerenciadorescolar.model;

import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rm;
    private String nome;
    private String turma;

    public Aluno(Long rm, String nome, String turma){
        this.rm = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.turma = turma;
    }
}
