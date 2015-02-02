package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Repository
public class RankingRepository {

    @PersistenceContext private EntityManager em;

    public List<Posicao> obtemDezPrimeirasPosicoes(){

        String jpql =   " select  new br.com.sidlar.dailyquiz.domain.ranking.Posicao(sum(r.pontuacao),r.membro) " +
                        " from RespostaQuestionario as r " +
                        " join r.membro " +
                        " group by r.membro ";
        TypedQuery<Posicao> query = em.createQuery(jpql,Posicao.class);
        query.setFirstResult(10);

        List<Posicao>  posicoes = query.getResultList();
        return posicoes;

    }
}
