package io.github.tecflyingcommunity.evoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Candidato  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private int numero;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria; 
	
	
	@OneToOne
	@JoinColumn(name="eleitor_id")
	@MapsId
	private Eleitor eleitor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="partido_id")
	private Partido partido;
	
	
	@OneToMany(mappedBy = "candidato", cascade = CascadeType.ALL)
	private List<Voto> votos = new ArrayList<>();

	public Candidato(Integer id, int numero, Eleitor eleitor, Partido partido) {
		super();
		this.id = id;
		this.numero = numero;
		this.eleitor = eleitor;
		this.partido = partido;
	}

	public Candidato() {
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

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Voto voto) {
		this.votos.add(voto);
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
		Candidato other = (Candidato) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Candidato [id=" + id + ", numero=" + numero + ", eleitor=" + eleitor + ", partido=" + partido
				+ ", votos=" + votos + "]";
	}

	
	
	
}
