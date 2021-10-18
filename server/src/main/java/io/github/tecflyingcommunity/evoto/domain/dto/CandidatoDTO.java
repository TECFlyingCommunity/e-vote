package io.github.tecflyingcommunity.evoto.domain.dto;



public class CandidatoDTO {
	private Integer id;
	private int numero;
	private Integer categoriaID; 
	private Integer eleitorID;
	private Integer partidoID;
	public CandidatoDTO(Integer id, int numero, Integer categoriaID, Integer eleitorID, Integer partidoID) {
		super();
		this.id = id;
		this.numero = numero;
		this.categoriaID = categoriaID;
		this.eleitorID = eleitorID;
		this.partidoID = partidoID;
	}
	public CandidatoDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Integer getCategoriaID() {
		return categoriaID;
	}
	public void setCategoriaID(Integer categoriaID) {
		this.categoriaID = categoriaID;
	}
	public Integer getEleitorID() {
		return eleitorID;
	}
	public void setEleitorID(Integer eleitorID) {
		this.eleitorID = eleitorID;
	}
	public Integer getPartidoID() {
		return partidoID;
	}
	public void setPartidoID(Integer partidoID) {
		this.partidoID = partidoID;
	}
	
	
	
	

}
