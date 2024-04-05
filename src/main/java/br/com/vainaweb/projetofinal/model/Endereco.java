package br.com.vainaweb.projetofinal.model;

import br.com.vainaweb.projetofinal.dto.DadosEndereco;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;

    private String cidade;
    private String uf;

    public Endereco(String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public Endereco(DadosEndereco dados) {
        this.cep = dados.cep();
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }
}
