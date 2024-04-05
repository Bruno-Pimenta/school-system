package br.com.vainaweb.projetofinal.model;

import br.com.vainaweb.projetofinal.dto.DadosAluno;
import br.com.vainaweb.projetofinal.enums.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Table(name = "tb_alunos") //Defino o nome da minha tabela
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa{
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Curso curso;

   public Aluno(DadosAluno dados) {
        super(dados.nome(), dados.cpf(), dados.email(), dados.endereco());
        this.telefone = dados.telefone();
        this.curso = dados.curso();
    }
}
