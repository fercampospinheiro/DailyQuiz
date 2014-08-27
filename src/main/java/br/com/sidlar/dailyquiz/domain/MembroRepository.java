package br.com.sidlar.dailyquiz.domain;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


/**
 * @author Fernando
 */
@Component
public class MembroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Membro buscaMembroComUserName(String userName, String senha){
		try {
			Membro  membro = (Membro)entityManager.createQuery
				(
					"select m from membro as m where m.userName = :userName and m.senha = :senha "
				)
				.setParameter("userName", userName)
				.setParameter("senha", senha)
				.getSingleResult();

			return membro;
		} catch (NoResultException e) {
			return null;
		}
	}

	public void insereNovoMembro(Membro membro){
		entityManager.persist(membro);
	}

}
