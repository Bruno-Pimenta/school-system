package br.com.vainaweb.projetofinal.service;

import br.com.vainaweb.projetofinal.model.Aluno;
import br.com.vainaweb.projetofinal.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public void cadastrarAluno(Aluno aluno){
        alunoRepository.save(aluno);
    }

    public List<Aluno> buscarTodosAlunos(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id){
        return alunoRepository.findById(id);
    }

    public void atualizarAluno(Long id, Aluno aluno){
        aluno.setId(id);
        alunoRepository.save(aluno);
    }

    public void deletarAluno(Long id){
        alunoRepository.deleteById(id);
    }
}
