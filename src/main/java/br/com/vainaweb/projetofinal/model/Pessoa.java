package br.com.vainaweb.projetofinal.model;

import br.com.vainaweb.projetofinal.dto.DadosEndereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @CPF
    @Column(unique = true)
    private String cpf;
    @Email
    @Column(unique = true)
    private String email;
    @Embedded
    private Endereco endereco;

    public Pessoa(String nome, String cpf, String email, DadosEndereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = new Endereco(endereco);
    }
}