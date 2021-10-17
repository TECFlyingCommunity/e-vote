package io.github.tecflyingcommunity.evoto.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Voto  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "eleitor_id")
	private Eleitor eleitor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="candidato_id")
	private Candidato candidato;
	
	
	public Voto(Integer id, Eleitor eleitor, Candidato candidato) {
		super();
		this.id = id;
		this.eleitor = eleitor;
		this.candidato = candidato;
	}
	public Voto() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Voto [id=" + id + ", eleitor=" + eleitor + ", candidato=" + candidato + "]";
	}
	
	
	
	
	

}
