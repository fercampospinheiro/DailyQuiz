package br.com.sidlar.dailyquiz.domain;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * Classe que disponibiliza os membros do domínio e métodos para sua manipulação
 * @author Fernando de Campos Pinheiro
 */
@Repository
public class MembroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Procura a existência do membro com o e-mail informado e retorna o mesmo
	 * @param email e-mail do membro do site
	 * @return Membro entidade retornada
	 * @throws UsuarioOuSenhaInexistenteException
	 */
	public @Nullable Membro buscaPorEmail(String email){

		String jpql = "select m from Membro as m where m.email = :email ";

		TypedQuery<Membro> query = entityManager.createQuery(jpql,Membro.class);
		query.setParameter("email",email);

		try {
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			throw new EntidadeNaoExistenteException("Entidade não encontrada no banco com o e-mail : "+ email,e);
		}
	}


	/**
	 * Adiciona um novo membro ao repositório
	 * @param membro
	 */
	public void adicionaNovoMembro(Membro membro){
		entityManager.persist(membro);
	}

}
