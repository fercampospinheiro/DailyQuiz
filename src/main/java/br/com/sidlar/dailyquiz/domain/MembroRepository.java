package br.com.sidlar.dailyquiz.domain;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


/**
 * @author Fernando
 */
@Repository
public class MembroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Membro buscaMembroPorCredencial(String userName, String senha){
		try {
			Membro  membro = (Membro)entityManager.createQuery
				(
					"select m from membro as m where m.userName = :userName and m.senha = :senha "
				)
				.setParameter("userName", userName)
				.setParameter("senha", senha)
				.getSingleResult();

			return membro;
		}
		catch (NoResultException e) {
			return new Membro();
		}
	}

	public void insereNovoMembro(Membro membro){
		entityManager.persist(membro);
	}

}
