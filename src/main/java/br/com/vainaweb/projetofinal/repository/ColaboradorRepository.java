package br.com.vainaweb.projetofinal.repository;

import br.com.vainaweb.projetofinal.model.Aluno;
import br.com.vainaweb.projetofinal.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
    Optional<Colaborador> findByCpf(String cpf);

    Optional<Colaborador> findByEmail(String email);
}
