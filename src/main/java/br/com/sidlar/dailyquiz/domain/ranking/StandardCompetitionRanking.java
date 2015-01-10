package br.com.sidlar.dailyquiz.domain.ranking;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@author Fernando de Campos Pinheiro
 */
@Component
public class StandardCompetitionRanking implements ClassificacaoRanking {


    @Override
    public List<ItemRanking> classifica(List<ItemRanking> itensRanking) {

        int pontuacaoInicial = 0;
        int ordem = 1;

//        for (ItemRanking item : itensRanking) {
//         /*   if (item.getPontuacao() > pontuacaoInicial ) {
//                pontuacaoInicial = item.getPontuacao();
//                item.setOrdem(ordem);
//                ordem = +1;
//            } else if (item.getPontuacao() == pontuacaoInicial) {
//                item.setOrdem(ordem);
//                ordem = (itensRanking.size() - ordem);
//            }else{
//                item.setOrdem(ordem);
//                ordem = ordem +1;
//            }*/
//        }
        return itensRanking;
    }

}
