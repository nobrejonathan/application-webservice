package br.ucb.talp.model.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table (name = "alunos")
@XmlRootElement
@NamedQueries ({
	@NamedQuery (name = "getAllAlunos", query = "SELECT a FROM Aluno a"),
	@NamedQuery (name = "getAlunoByMatricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula"),
	@NamedQuery (name = "getAlunoByID", query = "SELECT a FROM Aluno a WHERE a.id = :id")
})
public class Aluno implements Serializable {
	private static final long serialVersionUID = -2268788497791622732L;
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String matricula;
	private String nome;
	private Double nota;
	
	public Aluno() {
	}
	
	public Aluno(String matricula, String nome, Double nota) {
		setMatricula(matricula);
		setNome(nome);
		setNota(nota);
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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + ", nome=" + nome + ", nota=" + nota + "]";
	}
}
