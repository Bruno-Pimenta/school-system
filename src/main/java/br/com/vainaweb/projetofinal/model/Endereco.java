package br.com.vainaweb.projetofinal.model;

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
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(String cep, String logradouro, Integer numero, String bairro, String complemento, String cidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.uf = uf;
    }
}
