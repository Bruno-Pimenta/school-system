package br.com.vainaweb.projetofinal.dto;

public record DadosEndereco(String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf) {
}
