package io.github.tecflyingcommunity.evoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.tecflyingcommunity.evoto.domain.Entity.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

}
