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
import javax.persistence.OneToMany;

@Entity
public class Partido  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String nome;
	private int numero;
	
	@OneToMany(mappedBy="partido", cascade=CascadeType.ALL)
	private List<Candidato> candidatos = new ArrayList<Candidato>();

	public Partido(Integer id, String nome, int numero) {
		super();
		this.id = id;
		this.nome = nome;
		this.numero = numero;
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
