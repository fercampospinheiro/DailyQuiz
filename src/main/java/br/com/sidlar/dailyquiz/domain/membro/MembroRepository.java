package br.com.sidlar.dailyquiz.domain.membro;
import br.com.sidlar.dailyquiz.domain.excecoes.EntidadeInexistenteException;
import br.com.sidlar.dailyquiz.domain.excecoes.EntidadeJaExistenteException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * Repositório de membros da apilacação
 * @author Fernando de Campos Pinheiro
 */
@Repository
public class MembroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Busca por membros que possuam o e-mail informado
	 * @param email do membro do site
	 * @return Membro com email especificado
	 * @throws br.com.sidlar.dailyquiz.domain.excecoes.EntidadeInexistenteException caso não exista membro
	 */
	public @Nullable Membro buscaPorEmail(String email){

		String jpql = "select m from Membro as m where m.email = :email ";

		TypedQuery<Membro> query = entityManager.createQuery(jpql,Membro.class);
		query.setParameter("email",email);

		try {
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			throw new EntidadeInexistenteException("E-mail não cadastrado : "+ email,e);
		}
	}


	/**
	 * Adiciona um novo membro ao repositório
	 * Seguindo os passos abaixo:
	 * <ul>
	 * <li>Procura no banco algum membro com o email informado</li>
	 * <li>Se o usuário não existir grava no banco</li>
	 * <li>Caso o usuário ja exista lança uma {@code EmailOuSenhaInexistenteException }</li>
	 * </ul>
	 * @param membro
	 */
    @Transactional
	public void adicionaNovoMembro(Membro membro) {
		if(!contem(membro)) {
			entityManager.persist(membro);
		}
		else{
			throw  new EntidadeJaExistenteException("Membro já existente no repositório");
		}
	}

	private boolean contem(Membro membro){
		return entityManager.contains(membro);
	}

    /**
     * Verifica se existe o e-mail informado entre os membros da aplicação
     */

    public boolean  existeEmail(String email){

        String jpql = "select m from Membro as m where m.email = :email ";

        TypedQuery<Membro> query = entityManager.createQuery(jpql , Membro.class);
        query.setParameter("email", email);

        try {
            query.getSingleResult();
            return true;
        }
        catch (NoResultException e) {
            return false;
        }
    }


    public Membro buscaPorId(Integer id){
    	return entityManager.find(Membro.class, id);
    }
    
}
