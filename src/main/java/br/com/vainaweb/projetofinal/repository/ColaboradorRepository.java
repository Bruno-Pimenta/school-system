package br.com.vainaweb.projetofinal.repository;

import br.com.vainaweb.projetofinal.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
