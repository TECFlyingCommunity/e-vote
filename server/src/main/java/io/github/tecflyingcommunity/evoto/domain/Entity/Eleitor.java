package io.github.tecflyingcommunity.evoto.domain.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Eleitor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String titulo;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "eleitor")
	private Voto voto;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, mappedBy="eleitor")
	private Candidato candidato;
	
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL, mappedBy="eleitor")
	private Adm adm ;
	
	public Eleitor(String nome, String email, String senha, String cpf, String titulo) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.titulo = titulo;
	}
	public Eleitor() {
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
	public Voto getVoto() {
		return voto;
	}
	public void setVoto(Voto voto) {
		this.voto = voto;
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
				+ ", titulo=" + titulo + ", voto=" + voto + ", candidato=" + candidato + ", adm=" + adm + "]";
	}
	
	
	
	
	
	
}
