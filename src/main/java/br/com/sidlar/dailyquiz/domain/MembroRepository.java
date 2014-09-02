package br.com.sidlar.dailyquiz.domain;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


/**
 * @author Fernando de Campos Pinheiro
 */
@Repository
public class MembroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public @Nullable Membro buscaMembroPorCredencial(String userName, String senha){
		try {
			Membro  membro = (Membro)entityManager.createQuery
				(
					"select m from Membro as m where m.userName = :userName and m.senha = :senha "
				)
				.setParameter("userName", userName)
				.setParameter("senha", senha)
				.getSingleResult();

			return membro;
		}
		catch (NoResultException e) {
			return null;
		}
	}

	public void insereNovoMembro(Membro membro){
		entityManager.persist(membro);
	}

}
