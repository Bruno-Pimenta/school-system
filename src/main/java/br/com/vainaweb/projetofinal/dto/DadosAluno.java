package br.com.vainaweb.projetofinal.dto;

import br.com.vainaweb.projetofinal.enums.Curso;
import jakarta.validation.Valid;

public record DadosAluno(String nome, String cpf, String telefone, String email, @Valid DadosEndereco endereco, Curso curso) {
}
