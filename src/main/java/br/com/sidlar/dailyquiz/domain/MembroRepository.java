package br.com.sidlar.dailyquiz.domain;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Fernando_2 on 22/08/14.
 */
@Component
public class MembroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Membro buscaMembro(Membro membro){
		return entityManager.find(Membro.class,membro);
	}

	public Membro contemUsuarioNosMembros(String userName, String senha){
		Membro  membro = (Membro)entityManager.createQuery
            (
                "select membro from membro where membro.userName ="+userName +"  and membro.senha = "+ senha
            )
            .getSingleResult();
			return membro;
	}

	public List<Membro> buscaTodosMembros(){
		return entityManager.createQuery("select m from membro m").getResultList();
	}



}
