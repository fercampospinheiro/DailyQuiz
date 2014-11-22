package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questao.Questao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Fernando de Campos Pinheiro
 */
@Repository
public class QuestaoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Questao buscaPorId(Integer id){
        return em.find(Questao.class,id);
    }
}
