package com.fiap.gerenciadorescolar.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.server.ResponseStatusException;

import com.fiap.gerenciadorescolar.model.Aluno;
import com.fiap.gerenciadorescolar.repository.AlunoRepository;

@RestController
@RequestMapping("Aluno")
public class AlunoController {
    
    
    Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    AlunoRepository repository;


    @GetMapping()
    public List<Aluno> index(){
        return repository.findAll();
    }
    
    @PostMapping()
    @ResponseStatus(code = CREATED)
    public Aluno AdicionarAluno(@RequestBody Aluno aluno) {
        log.info("cadastrando aluno" + aluno);
        repository.save(aluno);
        return aluno;
    }

    @GetMapping("{rm}")
    public ResponseEntity<Aluno> show(@PathVariable Long rm){
        log.info("buscar aluno por id {} ", rm);

        return repository
                    .findById(rm)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

    }
    
    @DeleteMapping("{rm}")
    public ResponseEntity<Object> destroy(@PathVariable Long rm){
        log.info("Apagando categoria com rm {}", rm);

        extracted(rm);

        repository.deleteById(rm);
        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping("{rm}")
    public ResponseEntity<Aluno> atualizar (@PathVariable Long rm, @RequestBody Aluno aluno){
        log.info("Atualizando aluno com rm {} para {}", rm, aluno);

        extracted(rm);
        aluno.setRm(rm);
        repository.save(aluno);
        return ResponseEntity.ok(aluno);
    }
    
    public void extracted(Long id) {
        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe categoria com o id informado"));
    }   

    
}
