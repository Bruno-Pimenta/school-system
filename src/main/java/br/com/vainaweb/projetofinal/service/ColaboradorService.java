package br.com.vainaweb.projetofinal.service;

import br.com.vainaweb.projetofinal.dto.DadosEndereco;
import br.com.vainaweb.projetofinal.error.DetectaErro;
import br.com.vainaweb.projetofinal.model.Colaborador;
import br.com.vainaweb.projetofinal.model.Endereco;
import br.com.vainaweb.projetofinal.dto.DadosColaborador;
import br.com.vainaweb.projetofinal.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public DetectaErro cadastrarColaborador(DadosColaborador dados){
        Optional<Colaborador> colaboradorCpf = colaboradorRepository.findByCpf(dados.cpf());
        Optional<Colaborador> colaboradorEmail = colaboradorRepository.findByEmail(dados.email());

        if(colaboradorCpf.isPresent()){
            return new DetectaErro(false, "CPF Já cadastrado");
        }else{
            if(colaboradorEmail.isPresent()){
                return new DetectaErro(false, "E-mail Já cadastrado");

            }else{
                colaboradorRepository.save(new Colaborador(dados));
                return new DetectaErro(true, "Colaborador cadastrado com sucesso!!");
            }
        }
    }

    public List<DadosColaborador> buscarTodosOsColaboradores(){
        List<Colaborador> colaboradores = colaboradorRepository.findAll();
        List<DadosColaborador> dadosColaboradores = colaboradores.
            stream().map(colaborador->{
                return new DadosColaborador(
                    colaborador.getNome(),
                    colaborador.getCpf(),
                    colaborador.getEmail(),
                    new DadosEndereco(
                        colaborador.getEndereco().getCep(),
                        colaborador.getEndereco().getLogradouro(),
                        colaborador.getEndereco().getNumero(),
                        colaborador.getEndereco().getComplemento(),
                        colaborador.getEndereco().getBairro(),
                        colaborador.getEndereco().getCidade(),
                        colaborador.getEndereco().getUf()
                    ),
                    colaborador.getCargo()
                );
            }).collect(Collectors.toList());
        return dadosColaboradores;
    }

    public Optional<DadosColaborador> buscarColaboradorPorId(Long id) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if (colaborador.isPresent()) {
            Colaborador colaboradorEncontrado = colaborador.get();
            DadosColaborador dados = new DadosColaborador(
                    colaboradorEncontrado.getNome(),
                    colaboradorEncontrado.getCpf(),
                    colaboradorEncontrado.getEmail(),
                    new DadosEndereco(colaboradorEncontrado.getEndereco().getCep(),
                            colaboradorEncontrado.getEndereco().getLogradouro(),
                            colaboradorEncontrado.getEndereco().getNumero(),
                            colaboradorEncontrado.getEndereco().getComplemento(),
                            colaboradorEncontrado.getEndereco().getBairro(),
                            colaboradorEncontrado.getEndereco().getCidade(),
                            colaboradorEncontrado.getEndereco().getUf()
                    ),
                    colaboradorEncontrado.getCargo()
            );
            return Optional.ofNullable(dados);
        }
        Optional<DadosColaborador> optional = Optional.ofNullable(null);
        return optional;
    }

    public DetectaErro atualizarColaborador(Colaborador colaborador, DadosColaborador dados) {
        if (dados.nome() != null) {
            colaborador.setNome(dados.nome());
        }

        if (dados.endereco() != null) {
            colaborador.setEndereco(new Endereco(dados.endereco()));
        }

        if (dados.cargo() != null) {
            colaborador.setCargo(dados.cargo());
        }

        if (dados.email()!=null && !colaboradorRepository.findByEmail(dados.email()).isPresent()){
            colaborador.setEmail(dados.email());
            colaboradorRepository.save(colaborador);
            return new DetectaErro(true, "O registro do colaborador foi atualizado com sucesso!");
        }
        return new DetectaErro(false, "Esse E-mail já está cadastrado, tente com outro!");
    }

}
