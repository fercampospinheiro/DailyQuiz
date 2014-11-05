package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Repository
public class QuestionarioRespository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Questionario> buscaPorData(DateTime dataDisponivel){
        String jpql = "select q from Questionario q where q.dataDisponivel = :dataDisponivel";
        TypedQuery<Questionario> query = em.createQuery(jpql,Questionario.class);
        query.setParameter("dataDisponivel",dataDisponivel);
        return query.getResultList();
    }



}
