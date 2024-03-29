package br.com.vainaweb.projetofinal.controller;

import br.com.vainaweb.projetofinal.model.Aluno;
import br.com.vainaweb.projetofinal.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public void cadastrarAluno(@RequestBody Aluno aluno){
        alunoService.cadastrarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> buscarTodosAlunos(){
        return alunoService.buscarTodosAlunos();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> buscarAlunoPorId(@PathVariable Long id){
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizarAluno(@RequestBody Aluno aluno, @PathVariable Long id){
        alunoService.atualizarAluno(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
    }

}
