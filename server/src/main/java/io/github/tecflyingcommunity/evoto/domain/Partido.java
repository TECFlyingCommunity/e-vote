package io.github.tecflyingcommunity.evoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Partido  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String nome;

	@Column(unique=true)
	private int numero;

	private String sigla;
	
	@JsonIgnore
	@OneToMany(mappedBy="partido", cascade=CascadeType.ALL)
	private List<Candidato> candidatos = new ArrayList<Candidato>();

	public Partido(Integer id, String nome, int numero, String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
		this.sigla = sigla;
	}

	public Partido() {
		super();
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(Candidato candidato) {
		this.candidatos.add(candidato);
	}
	
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
		Partido other = (Partido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Partido [id=" + id + ", nome=" + nome + ", numero=" + numero + ", candidatos=" + candidatos + "]";
	}
	
	
	

}
