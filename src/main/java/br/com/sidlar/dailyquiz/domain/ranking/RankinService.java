package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor Fernando de Campos Pinheiro
 */
@Service
public class RankinService {
    @Autowired
    private RankingRepository repository;
    @Autowired
    private ClassificacaoRanking classificacao ;

    public  List<ItemRanking> obtemItens(){
        List<ItemRanking> itensRanking  = repository.buscaItensRanking();
        return classificacao.classifica(itensRanking);
    }


}
