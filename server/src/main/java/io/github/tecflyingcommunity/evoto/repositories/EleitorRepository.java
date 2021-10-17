package io.github.tecflyingcommunity.evoto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.tecflyingcommunity.evoto.domain.Eleitor;

@Repository
public interface EleitorRepository extends JpaRepository<Eleitor, Integer> {

}
