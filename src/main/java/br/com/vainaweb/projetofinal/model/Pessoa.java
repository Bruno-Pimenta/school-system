package br.com.vainaweb.projetofinal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Email
    @Column(unique = true)
    private String email;

    @CPF
    @Column(unique = true)
    private String cpf;

    @Embedded
    private Endereco endereco;

    public Pessoa(String nome, String email, String cpf, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
    }
}