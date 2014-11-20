package br.com.sidlar.dailyquiz.domain.respostaQuestionario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.sidlar.dailyquiz.domain.membro.Membro;

@Component
public class RespostaQuestionarioRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void salva(RespostaQuestionario resposta ){
		em.persist(resposta);
	}
	
	@Transactional
	public List<RespostaQuestionario> buscaPorMembro(Membro membro){
		
		String jpql = "select r "
					+ "from RespostaQuestionario as r "
					+ "where r.idMembro:id "
					+ "order by r.dataReposta ";
		TypedQuery<RespostaQuestionario> query = em.createQuery(jpql,RespostaQuestionario.class); 
		query.setMaxResults(5);
		query.setParameter("id", membro.getId());
		return query.getResultList();
	}
	
}
