package br.com.vainaweb.projetofinal.controller;

import br.com.vainaweb.projetofinal.model.Colaborador;
import br.com.vainaweb.projetofinal.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping
    public void cadastrarColaborador(@RequestBody Colaborador colaborador){
        colaboradorService.cadastrarColaborador(colaborador);
    }

    @GetMapping
    public List<Colaborador> buscarTodosColaboradores(){
        return colaboradorService.buscarTodosColaboradores();
    }

    @GetMapping("/{id}")
    public Optional<Colaborador> buscarColaborador(@PathVariable Long id){
        return colaboradorService.buscarColaborador(id);
    }

    @PutMapping("/{id}")
    public void atualizarColaborador(@PathVariable Long id, @RequestBody Colaborador colaborador){
        colaboradorService.atualizarColaborador(id, colaborador);
    }

    @DeleteMapping("/{id}")
    public void deletarColaborador(@PathVariable Long id){
        colaboradorService.deletarColaborador(id);
    }
}
