package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario;

import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
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
public class QuestionarioRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Questionario> buscaPorData(DateTime dataDisponivel){
        String jpql = "select q from Questionario q where q.dataDisponivel = :dataDisponivel";
        TypedQuery<Questionario> query = em.createQuery(jpql,Questionario.class);
        query.setParameter("dataDisponivel",dataDisponivel);
        return query.getResultList();
    }


    public List<Questionario> buscaTodos(){
            String jpql = "select distinct q from  Questionario as q join fetch q.questoes ";
            return Lists.newArrayList(em.createQuery(jpql, Questionario.class).getResultList());
        }

    public Questionario buscaQuestionarioPorId(Integer id){
        String jpql =   " select  distinct q from " +
                        " Questionario as q " +
                        " join fetch q.questoes a " +
                        " join fetch a.alternativas " +
                        " where q.id = :id ";
        TypedQuery <Questionario> query = em.createQuery(jpql,Questionario.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Transactional
    public void salva(RespostaQuestionario resposta){
        em.persist(resposta);
    }

}
