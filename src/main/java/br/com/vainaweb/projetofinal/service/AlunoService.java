package br.com.vainaweb.projetofinal.service;

import br.com.vainaweb.projetofinal.dto.DadosAluno;
import br.com.vainaweb.projetofinal.dto.DadosEndereco;
import br.com.vainaweb.projetofinal.error.DetectaErro;
import br.com.vainaweb.projetofinal.model.Aluno;
import br.com.vainaweb.projetofinal.model.Endereco;
import br.com.vainaweb.projetofinal.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public DetectaErro cadastrarAluno(DadosAluno dados){
        Optional<Aluno> alunoCpf = alunoRepository.findByCpf(dados.cpf());
        Optional<Aluno> alunoEmail = alunoRepository.findByEmail(dados.email());

        if(alunoCpf.isPresent()){
            return new DetectaErro(false, "CPF Já cadastrado");
        }else{
            if(alunoEmail.isPresent()){
                return new DetectaErro(false, "E-mail Já cadastrado");

            }else{
                alunoRepository.save(new Aluno(dados));
                return new DetectaErro(true, "Aluno cadastrado com sucesso!!");
            }
        }
    }

    public List<DadosAluno> buscarTodosOsAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        List<DadosAluno> dadosAlunos = alunos.
                stream().map(aluno->{
                    return new DadosAluno(
                            aluno.getNome(),
                            aluno.getCpf(),
                            aluno.getTelefone(),
                            aluno.getEmail(),
                            new DadosEndereco(
                                    aluno.getEndereco().getCep(),
                                    aluno.getEndereco().getLogradouro(),
                                    aluno.getEndereco().getNumero(),
                                    aluno.getEndereco().getComplemento(),
                                    aluno.getEndereco().getBairro(),
                                    aluno.getEndereco().getCidade(),
                                    aluno.getEndereco().getUf()
                            ),
                            aluno.getCurso()
                    );
                }).collect(Collectors.toList());
        return dadosAlunos;
    }

    public Optional<DadosAluno> buscarAlunoPorId(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if (aluno.isPresent()) {
            Aluno alunoEncontrado = aluno.get();
            DadosAluno dados = new DadosAluno(
                    alunoEncontrado.getNome(),
                    alunoEncontrado.getCpf(),
                    alunoEncontrado.getTelefone(),
                    alunoEncontrado.getEmail(),
                    new DadosEndereco(alunoEncontrado.getEndereco().getCep(),
                            alunoEncontrado.getEndereco().getLogradouro(),
                            alunoEncontrado.getEndereco().getNumero(),
                            alunoEncontrado.getEndereco().getComplemento(),
                            alunoEncontrado.getEndereco().getBairro(),
                            alunoEncontrado.getEndereco().getCidade(),
                            alunoEncontrado.getEndereco().getUf()
                    ),
                    alunoEncontrado.getCurso()
            );
            return Optional.of(dados);
        }
        Optional<DadosAluno> optional = Optional.ofNullable(null);
        return optional;
    }

    public DetectaErro atualizarAluno(Aluno aluno, DadosAluno dados){
        if (dados.nome() != null) {
            aluno.setNome(dados.nome());
        }

        if (dados.endereco() != null) {
            aluno.setEndereco(new Endereco(dados.endereco()));
        }

        if (dados.telefone() !=null){
            aluno.setTelefone(dados.telefone());
        }

        if (dados.curso() != null) {
            aluno.setCurso(dados.curso());
        }

         if (dados.email()!=null && !alunoRepository.findByEmail(dados.email()).isPresent()){
             aluno.setEmail(dados.email());
             alunoRepository.save(aluno);
             return new DetectaErro(true, "O registro do colaborador foi atualizado com sucesso!");
        }
        return new DetectaErro(false, "Esse E-mail já está cadastrado, tente com outro!");
    }
}
