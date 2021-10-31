package io.github.tecflyingcommunity.evoto.domain.dto;

import java.io.Serializable;

public class VotoDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
	
	private Integer id;
	

	private Integer eleitorID;

	private Integer candidatoID;

	public VotoDTO(Integer id, Integer eleitorID, Integer candidatoID) {
		super();
		this.id = id;
		this.eleitorID = eleitorID;
		this.candidatoID = candidatoID;
	}

	public VotoDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEleitorID() {
		return eleitorID;
	}

	public void setEleitorID(Integer eleitorID) {
		this.eleitorID = eleitorID;
	}

	public Integer getCandidatoID() {
		return candidatoID;
	}

	public void setCandidatoID(Integer candidatoID) {
		this.candidatoID = candidatoID;
	}
	
	
}
