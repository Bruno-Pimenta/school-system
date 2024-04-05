package br.com.vainaweb.projetofinal.dto;

import br.com.vainaweb.projetofinal.enums.Cargo;
import jakarta.validation.Valid;

public record DadosColaborador(String nome, String cpf, String email, @Valid DadosEndereco endereco, Cargo cargo ) {
}
