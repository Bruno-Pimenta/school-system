package br.com.vainaweb.projetofinal.service;

import br.com.vainaweb.projetofinal.model.Colaborador;
import br.com.vainaweb.projetofinal.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public void cadastrarColaborador(Colaborador colaborador){
        colaboradorRepository.save(colaborador);
    }

    public List<Colaborador> buscarTodosColaboradores(){
        return colaboradorRepository.findAll();
    }

    public Optional<Colaborador> buscarColaborador(Long id){
        return colaboradorRepository.findById(id);
    }

    public void atualizarColaborador(Long id, Colaborador colaborador){
        colaborador.setId(id);
        colaboradorRepository.save(colaborador);
    }

    public void deletarColaborador(@PathVariable Long id){
        colaboradorRepository.deleteById(id);
    }
}
