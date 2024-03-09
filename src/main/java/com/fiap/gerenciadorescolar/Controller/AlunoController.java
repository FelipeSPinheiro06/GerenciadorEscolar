package com.fiap.gerenciadorescolar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        log.info("cadastrando aluno" + categoria);
        repository.add(aluno);
        return aluno;
    }

    @GetMapping("{rm}")
    public ResponseEntity<Categoria> show(@PathVariable Long Rm){
        log.info("buscar aluno por id {} ", id);

        /*for(Aluno aluno : repository){
            if (categoria.rm().equals(rm))
                return ResponseEntity.ok(categoria);
        }*/
                                                                     //FindFirst vai pegar o elemento do filtro que passou
        var alunoEncontrado = repository
        .stream()
        .filter( a->  a.rm().equals(rm))
        .findFirst();
                                //se estiver vazia
        if(categoriaEncontrada.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(alunoEncontrado.get() );

        

      
    }
    @DeleteMaping("{rm}")
    public ResponseEntity<Object> destroy(@PAthvAriable Long id){
        log.info("Apagando categoria com rm {}", rm);

        var alunoEncontrado = repository
        .stream()
        .filter( a->  a.rm().equals(rm))
        .findFirst();
        if (alunoEncontrado.isEmpty)
            return ResponseEntity.notFound().build();

        repository.remove(alunoEncontrado.get());

        return responseENtity.noContent().build();
    }
    @putMaping("{rm}")
    public ResponseEntity<Aluno> atualizar (@PathVariable Long rm, @RequestBody Aluno aluno){
        log.info("Atualizando aluno com rm {} para {}", rm, aluno);

        var alunoEncontrado = repository
        .stream()
        .filter( a->  a.rm().equals(rm))
        .findFirst();
        if (alunoEncontrado.isEmpty)
            return ResponseEntity.notFound().build();
        var AlunoAntigo = alunoEncontrado.get();
        var AlunoNovo = new Categoria(rm ,aluno.nome(), aluno.turma());

        repository.remove(AlunoAntigo);
        repository.add(categoriaNova);

        return ResponseEntity

        
        

    }
    
    

    
}
