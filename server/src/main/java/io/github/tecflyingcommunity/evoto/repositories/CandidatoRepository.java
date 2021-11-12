package io.github.tecflyingcommunity.evoto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.tecflyingcommunity.evoto.domain.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
    
    @Transactional(readOnly=true)
    Candidato findByNumero(int numero);
}
