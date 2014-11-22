package br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.alternativa;

import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Fernando de Campos Pinheiro
 */
@Repository
public class AlternativaRepository {

    @PersistenceContext
    private EntityManager em ;

    @Transactional
    public Alternativa buscaPorId(Integer id){
        return em.find(Alternativa.class, id);
    }
}
