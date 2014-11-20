package br.ucb.talp.model.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.ucb.talp.model.beans.Aluno;

@Stateless
public class AlunoBean {
	
	@PersistenceContext (unitName = "APP_JPA")
	private EntityManager manager;

	public void add(Aluno aluno) {
		getManager().persist(aluno);
	}

	public List<Aluno> getAll() {
		TypedQuery<Aluno> query = getManager().createNamedQuery("getAllAlunos", Aluno.class);
		return query.getResultList();
	}

	public Aluno findBy(String matricula) {
		TypedQuery<Aluno> query = getManager().createNamedQuery("getAlunoByMatricula", Aluno.class);
		query.setParameter("matricula", matricula);
		return query.getSingleResult();
	}

	public Aluno findBy(Integer id) {
		return getManager().find(Aluno.class, id);
	}

	private EntityManager getManager() {
		return manager;
	}
}
