package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario;

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

    @Transactional
    public List<Questionario> buscaPorData(DateTime dataDisponivel){
        String jpql = "select q from Questionario q where q.dataDisponivel = :dataDisponivel";
        TypedQuery<Questionario> query = em.createQuery(jpql,Questionario.class);
        query.setParameter("dataDisponivel",dataDisponivel);
        return query.getResultList();
    }

    @Transactional
    public List<Questionario> buscaTodos(){
            String jpql = "select q from  Questionario as q ";
            return Lists.newArrayList(em.createQuery(jpql, Questionario.class).getResultList());
        }

    public Questionario buscaQuestionarioPorId(Integer id){
        return em.find(Questionario.class,id);
    }

    @Transactional
    public void salva(RespostaQuestionario resposta){
        em.persist(resposta);
    }

}
