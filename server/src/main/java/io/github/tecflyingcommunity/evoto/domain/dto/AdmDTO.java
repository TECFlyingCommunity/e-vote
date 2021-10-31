package io.github.tecflyingcommunity.evoto.domain.dto;

import java.io.Serializable;

public class AdmDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;

	private Integer id;
	private String matricula;
	private Integer eleitorID;
	
	public AdmDTO() {
		super();
	}

	public AdmDTO(Integer id, String matricula, Integer eleitorID) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.eleitorID = eleitorID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatriculaID(String matricula) {
		this.matricula = matricula;
	}

	public Integer getEleitorID() {
		return eleitorID;
	}

	public void setEleitorID(Integer eleitorID) {
		this.eleitorID = eleitorID;
	}
	
	
	
	
}
