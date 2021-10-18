package io.github.tecflyingcommunity.evoto.domain.dto;

import java.io.Serializable;

public class CidadeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome;
	private int estadoID;
	
	
	public CidadeDTO() {
		super();
	}


	public CidadeDTO(Integer id, String nome, int estadoID) {
		super();
		this.id = id;
		this.nome = nome;
		this.estadoID = estadoID;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getEstadoID() {
		return estadoID;
	}


	public void setEstadoID(int estadoID) {
		this.estadoID = estadoID;
	}
	
	
	
	
	
	
}
