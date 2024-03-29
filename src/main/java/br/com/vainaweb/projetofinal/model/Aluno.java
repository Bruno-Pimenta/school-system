package br.com.vainaweb.projetofinal.model;

import br.com.vainaweb.projetofinal.enums.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_alunos") //Defino o nome da minha tabela
@Entity
public class Aluno extends Pessoa{
    @Enumerated(EnumType.STRING)
    private Curso curso;

    private String telefone;

    public Aluno(String nome, String email, String cpf, Endereco endereco, Curso curso, String telefone) {
        super(nome, email, cpf, endereco);
        this.curso = curso;
        this.telefone = telefone;
    }
}
