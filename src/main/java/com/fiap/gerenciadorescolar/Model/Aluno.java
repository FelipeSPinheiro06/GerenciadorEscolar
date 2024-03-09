package com.fiap.gerenciadorescolar.Model;

import java.util.Random;

public class Aluno {
    private Long rm;
    private String nome;
    private String turma;

    public Aluno(Long rm, String nome, String turma){
        this.rm = Math.abs(new Random().nextLong());
        this.nome = nome;
        this.turma = turma;
    }

    public Long getRm() {
        return rm;
    }

    public void setRm(Long rm) {
        this.rm = rm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    } 
}
