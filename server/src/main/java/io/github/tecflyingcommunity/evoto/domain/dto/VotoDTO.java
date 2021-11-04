package io.github.tecflyingcommunity.evoto.domain.dto;

import java.io.Serializable;

import io.github.tecflyingcommunity.evoto.domain.Candidato;

public class VotoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Candidato candidato;

	private Integer quantVoto;

	public VotoDTO() {
		super();
	}

	public VotoDTO(Candidato candidato, Integer quantVoto) {
		this.candidato = candidato;
		this.quantVoto = quantVoto;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Integer getQuantVoto() {
		return quantVoto;
	}

	public void setQuantVoto(Integer quantVoto) {
		this.quantVoto = quantVoto;
	}

	


}
