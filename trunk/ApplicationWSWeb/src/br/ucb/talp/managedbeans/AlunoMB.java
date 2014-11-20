package br.ucb.talp.managedbeans;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;

import br.ucb.talp.enums.ResponseType;

@ManagedBean ("aluno")
@RequestScoped
public class AlunoMB {
	
	private String matricula;
	private String id;
	private ResponseType type;
	
	@PostConstruct
	public void init () {
		setType(ResponseType.XML);
	}
	
	public String buscarTodos() {
		return null;
	}
	
	public String buscarPorMatricula () {
		return null;
	}
	
	public String buscarPorID () {
		return null;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ResponseType getType() {
		return type;
	}
	public void setType(ResponseType type) {
		this.type = type;
	}
}
