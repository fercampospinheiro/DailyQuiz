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
    @PersistenceContext
    private EntityManager em;

    public List<ItemRanking> buscaItensRanking(){

        String jpql =   "select new br.com.sidlar.dailyquiz.domain.ranking.ItemRanking(r.id,m) " +
                        "from RespostaQuestionario as r " +
                        "join Membro as m " +
                        "where r.membro.id = m.id " +
                        "group by m ";
        TypedQuery<ItemRanking> query = em.createQuery(jpql,ItemRanking.class);
        return query.getResultList();
    }


}
