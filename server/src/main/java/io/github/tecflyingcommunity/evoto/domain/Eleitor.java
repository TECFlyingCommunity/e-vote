package io.github.tecflyingcommunity.evoto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.tecflyingcommunity.evoto.domain.enums.Perfil;


@Entity
public class Eleitor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String nome;

	@Column(unique=true)
	private String email;

	@Column(unique=true)
	private String cpf;

	@Column(unique=true)
	private String titulo;
	private String telefone;

	@JsonIgnore
	private String senha;


	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "eleitor")
	private List<Voto> votos = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, mappedBy="eleitor")
	@JoinColumn(name="candidato_id")
	private Candidato candidato;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, mappedBy="eleitor")
	private Adm adm ;
	

	public Eleitor(
			String nome, 
			String email, 
			String senha, 
			String cpf, 
			String titulo,
			String telefone,
			Cidade cidade) {

		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.titulo = titulo;
		this.cidade = cidade;
		this.telefone = telefone;
		addPerfil(Perfil.ELEITOR);

	}
	public Eleitor() {
		super();
		addPerfil(Perfil.ELEITOR);
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public List<Voto> getVotos() {
		return votos;
	}
	public void setVotos(Voto voto) {
		this.votos.add(voto);
	}
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Adm getAdm() {
		return adm;
	}
	public void setAdm(Adm adm) {
		this.adm = adm;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Eleitor other = (Eleitor) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Eleitor [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", titulo=" + titulo + " candidato=" + candidato + ", adm=" + adm + "]";
	}
	
	
	
	
	
	
}
