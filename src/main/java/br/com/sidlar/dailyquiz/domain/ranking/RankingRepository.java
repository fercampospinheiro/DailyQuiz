package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.ranking.ItemRanking;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @autor Fernando de Campos Pinheiro
 */
@Repository
public class RankingRepository {
    @PersistenceContext
    private EntityManager em;

    public List<ItemRanking> buscaItensRanking(){

        String jpql =   "select sum(r.numeroAcertos) , m " +
                        "from RespostaQuestionario as r " +
                        "join Membro as m " +
                        "where r.membro.id = m.id " +
                        "group by m ";
        TypedQuery<ItemRanking> query = em.createQuery(jpql,ItemRanking.class);
        return query.getResultList();
    }

}
