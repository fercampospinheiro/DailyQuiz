package br.com.sidlar.dailyquiz.domain.ranking;

import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.Questionario;
import br.com.sidlar.dailyquiz.domain.formulacaoQuestionario.questionario.QuestionarioRepository;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionario;
import br.com.sidlar.dailyquiz.domain.respostaQuestionario.RespostaQuestionarioRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 24/01/15.
 */
public class RankingFactory {

    @Autowired private RespostaQuestionarioRepository repository;

    public void porQtdPosicoes(int qtdPosicoes){

    }

    public List<Posicao> obtemPosicoes(){
        List<RespostaQuestionario> respostaQuestionarios = repository.buscaTodos();

        Posicao posicao  =  new Posicao();
        for(RespostaQuestionario resp : respostaQuestionarios){
            posicao.setMembro( resp.getMembro());
            int totalDeAcertos = 0;

            if( resp.getMembro().equals(posicao.getMembro())){
                totalDeAcertos += resp.numeroDeAcertos();
            }

            posicao.setPontuacao(totalDeAcertos);
        }
        List<Posicao> posicoes = Lists.newArrayList();
        posicoes.add(posicao);

        return  posicoes;
    }


}
