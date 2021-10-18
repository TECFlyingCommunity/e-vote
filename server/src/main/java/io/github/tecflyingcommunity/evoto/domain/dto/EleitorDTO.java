package io.github.tecflyingcommunity.evoto.domain.dto;

public class EleitorDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String titulo;
	private Integer cidadeID;
	
	public EleitorDTO(Integer id, String nome, String email, String senha, String cpf, String titulo,
			Integer cidadeID) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
		this.titulo = titulo;
		this.cidadeID = cidadeID;
	}

	public EleitorDTO() {
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

	public Integer getCidadeID() {
		return cidadeID;
	}

	public void setCidadeID(Integer cidadeID) {
		this.cidadeID = cidadeID;
	}
	
	

	
	
}
