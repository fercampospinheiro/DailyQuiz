package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  Fernando de Campos Pinheiro
 */
@Service
public class RankingService {

    @Autowired private RankingRepository repository;

    public Ranking obtemRanking(){
        List<Posicao> posicoes = repository.obtemDezPrimeirasPosicoes();
        Ranking ranking = new Ranking();
        ranking.ordenaAtraves(new StandardCompetitionRanking2(posicoes));
        return  ranking;
    }
}
