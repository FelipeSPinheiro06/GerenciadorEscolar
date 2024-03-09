package com.fiap.gerenciadorescolar.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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

import com.fiap.gerenciadorescolar.Model.Aluno;

@RestController
@RequestMapping("Aluno")
public class AlunoController {
    
    List <Aluno> repository =  new ArrayList<>();
    Logger log = LoggerFactory.getLogger(getClass());



    @GetMapping()
    public List<Aluno> index(){
        return repository;
    }
    
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Aluno AdicionarAluno(@RequestBody Aluno aluno) {
        log.info("cadastrando aluno" + aluno);
        repository.add(aluno);
        return aluno;
    }

    @GetMapping("{rm}")
    public ResponseEntity<Aluno> show(@PathVariable Long rm){
        log.info("buscar aluno por id {} ", rm);

        /*for(Aluno aluno : repository){
            if (categoria.rm().equals(rm))
                return ResponseEntity.ok(categoria);
        }*/
                                                                     //FindFirst vai pegar o elemento do filtro que passou
        var alunoEncontrado = getAlunoByID(rm);
                                //se estiver vazia
        if(alunoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(alunoEncontrado.get());
    }
    
    @DeleteMapping("{rm}")
    public ResponseEntity<Object> destroy(@PathVariable Long rm){
        log.info("Apagando categoria com rm {}", rm);

        var alunoEncontrado = getAlunoByID(rm);
        
        if (alunoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();

        repository.remove(alunoEncontrado.get());

        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping("{rm}")
    public ResponseEntity<Aluno> atualizar (@PathVariable Long rm, @RequestBody Aluno aluno){
        log.info("Atualizando aluno com rm {} para {}", rm, aluno);

        var alunoEncontrado = getAlunoByID(rm);
        if (alunoEncontrado.isEmpty())
            return ResponseEntity.notFound().build();
        
        var alunoAntigo = alunoEncontrado.get();
        var alunoNovo = new Aluno(rm ,aluno.getNome(), aluno.getTurma());

        repository.remove(alunoAntigo);
        repository.add(alunoNovo);

        return ResponseEntity.ok(alunoNovo);
    }
    
    private Optional<Aluno> getAlunoByID(Long rm) {
        var alunoEncontrado = repository
        .stream()
        .filter( a -> a.getRm().equals(rm))
        .findFirst();

        return alunoEncontrado;
    }    

    
}
