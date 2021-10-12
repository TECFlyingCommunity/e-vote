package io.github.tecflyingcommunity.evoto.domain.Entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Adm  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	private String matricula;
	
	@OneToOne
	@JoinColumn(name="eleitor_id")
	@MapsId
	private Eleitor eleitor;

	public Adm(Integer id, String matricula, Eleitor eleitor) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.eleitor = eleitor;
	}

	public Adm() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
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
		Adm other = (Adm) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Adm [id=" + id + ", matricula=" + matricula + ", eleitor=" + eleitor + "]";
	}
	
	
	
	

}
