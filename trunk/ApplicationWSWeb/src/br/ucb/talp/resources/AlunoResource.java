package br.ucb.talp.resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.ucb.talp.model.beans.Aluno;
import br.ucb.talp.model.sessionbeans.AlunoBean;

@Stateless
@Path ("/alunos")
public class AlunoResource {
	
	@EJB
	AlunoBean alunoBean;
	
	@PostConstruct
	public void init () {
		if (getAlunoBean().getAll().isEmpty()) {
			getAlunoBean().add(new Aluno("UC12105022", "Jonathan Nobre", 10.0));
			getAlunoBean().add(new Aluno("UC12105028", "Luciano dos Passos", 10.0));
		}
	}

	@GET
	@Path ("/find_matricula")
	@Produces (MediaType.APPLICATION_XML)
	public Aluno find(@QueryParam("matricula") String matricula) {
		return getAlunoBean().findBy(matricula);
	}
	
	@GET
	@Path ("/find_id")
	@Produces (MediaType.APPLICATION_XML)
	public Aluno find(@QueryParam("id") Integer id) {
		return getAlunoBean().findBy(id);
	}
	
	@GET
	@Produces (MediaType.APPLICATION_XML)
	public List<Aluno> getAll () {
		return getAlunoBean().getAll();
	}
	
	public AlunoBean getAlunoBean() {
		return alunoBean;
	}

	public void setAlunoBean(AlunoBean alunoBean) {
		this.alunoBean = alunoBean;
	}
}
