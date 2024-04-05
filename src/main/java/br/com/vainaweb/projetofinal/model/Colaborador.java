package br.com.vainaweb.projetofinal.model;

import br.com.vainaweb.projetofinal.dto.DadosColaborador;
import br.com.vainaweb.projetofinal.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity //Trata a classe como uma entidade
@Table(name = "tb_colaboradores") //Defino o nome da minha tabela
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador extends Pessoa{
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Colaborador(DadosColaborador dados) {
        super(dados.nome(), dados.cpf(), dados.email(), dados.endereco());
        this.cargo = dados.cargo();
    }
}