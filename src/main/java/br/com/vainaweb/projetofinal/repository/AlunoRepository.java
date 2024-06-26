package br.com.vainaweb.projetofinal.repository;

import br.com.vainaweb.projetofinal.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByCpf(String cpf);

    Optional<Aluno> findByEmail(String email);
}
