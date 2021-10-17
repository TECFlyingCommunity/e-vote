package io.github.tecflyingcommunity.evoto.repositories;

import org.springframework.stereotype.Repository;

import io.github.tecflyingcommunity.evoto.domain.Adm;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Integer>{

}
