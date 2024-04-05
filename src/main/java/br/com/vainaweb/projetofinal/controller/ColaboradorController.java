package br.com.vainaweb.projetofinal.controller;

import br.com.vainaweb.projetofinal.dto.DadosColaborador;
import br.com.vainaweb.projetofinal.error.DetectaErro;
import br.com.vainaweb.projetofinal.model.Colaborador;
import br.com.vainaweb.projetofinal.repository.ColaboradorRepository;
import br.com.vainaweb.projetofinal.service.ColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @PostMapping
    public ResponseEntity<String> cadastrarColaborador(@Valid @RequestBody DadosColaborador dados){
        DetectaErro resposta = colaboradorService.cadastrarColaborador(dados);
        if(resposta.getNoProblem()==true){
            return new ResponseEntity<>(resposta.getMensagem(), HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(resposta.getMensagem(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<DadosColaborador>> buscarTodosColaboradores(){
        List<DadosColaborador> dados = colaboradorService.buscarTodosOsColaboradores();
        return new ResponseEntity<>(dados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosColaborador> buscarColaboradorPorId(@PathVariable Long id){
        Optional<Colaborador> colaborador = Optional.ofNullable(colaboradorRepository.getReferenceById(id));
        Optional <DadosColaborador> dados = colaboradorService.buscarColaboradorPorId(id);
        var response = dados.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta)).
                orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarColaborador(@PathVariable Long id, @Valid @RequestBody DadosColaborador dados) {
        Optional<Colaborador> colaboradorOptional = colaboradorRepository.findById(id);
        if (colaboradorOptional.isPresent()) {
            Colaborador colaborador = colaboradorOptional.get();
            DetectaErro mensagem = colaboradorService.atualizarColaborador(colaborador, dados);
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
    public ResponseEntity<String> deletarColaborador(@PathVariable Long id){
        Optional<Colaborador> colaborador = colaboradorRepository.findById(id);
        if(colaborador.isPresent()){
            colaboradorRepository.deleteById(id);
            return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>("Não foi encontrado o colaborador com id informado.", HttpStatus.NOT_FOUND);
        }
    }
}
