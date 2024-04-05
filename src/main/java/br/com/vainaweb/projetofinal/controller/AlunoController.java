package br.com.vainaweb.projetofinal.controller;

import br.com.vainaweb.projetofinal.dto.DadosAluno;
import br.com.vainaweb.projetofinal.error.DetectaErro;
import br.com.vainaweb.projetofinal.model.Aluno;
import br.com.vainaweb.projetofinal.repository.AlunoRepository;
import br.com.vainaweb.projetofinal.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<String> cadastrarAluno(@Valid @RequestBody DadosAluno dados){
        DetectaErro resposta = alunoService.cadastrarAluno(dados);
        if(resposta.getNoProblem()==true){
            return new ResponseEntity<>(resposta.getMensagem(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(resposta.getMensagem(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<DadosAluno>> buscarTodosOsAlunos(){
        List<DadosAluno> dados = alunoService.buscarTodosOsAlunos();
        return new ResponseEntity<>(dados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosAluno> buscarAlunoPorId(@PathVariable Long id){
        Optional<Aluno> aluno = Optional.ofNullable(alunoRepository.getReferenceById(id));
        Optional <DadosAluno> dados = alunoService.buscarAlunoPorId(id);
        var response = dados.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarAluno(@PathVariable Long id, @Valid @RequestBody DadosAluno dados){
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            DetectaErro mensagem = alunoService.atualizarAluno(aluno, dados);
            if (mensagem.getNoProblem()) {
                return ResponseEntity.status(HttpStatus.OK).body(mensagem.getMensagem());
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem.getMensagem());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarAluno(@PathVariable Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isPresent()){
            alunoRepository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("Não foi encontrado o colaborador com id informado.", HttpStatus.NOT_FOUND);
        }
    }
}
