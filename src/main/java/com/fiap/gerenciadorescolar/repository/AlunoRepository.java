package com.fiap.gerenciadorescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.gerenciadorescolar.Model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
