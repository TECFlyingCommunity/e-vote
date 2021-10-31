package io.github.tecflyingcommunity.evoto.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import io.github.tecflyingcommunity.evoto.services.validation.EleitorInsert;

@EleitorInsert
public class NovoEleitorDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
	

    @NotEmpty(message="Preenchimento obrigatório")
	private String nome;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="Email inválido")
	private String email;   

    @NotEmpty(message="Preenchimento obrigatório")
	private String senha;

    @NotEmpty(message="Preenchimento obrigatório")
	private String cpf;

    @NotEmpty(message="Preenchimento obrigatório")
	private String titulo;

    @NotEmpty(message="Preenchimento obrigatório")
	private Integer cidadeID;
	
	public NovoEleitorDTO( String nome, String email, String senha, String cpf, String titulo,
			Integer cidadeID) {
		super();

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.titulo = titulo;
		this.cidadeID = cidadeID;
	}

	public NovoEleitorDTO() {
		super();
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

	public Integer getCidadeID() {
		return cidadeID;
	}

	public void setCidadeID(Integer cidadeID) {
		this.cidadeID = cidadeID;
	}
	
}
